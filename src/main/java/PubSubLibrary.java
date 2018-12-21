import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PubSubLibrary {

    private static volatile PubSubLibrary INSTANCE = null;

    private Map<Class<?>, Map<Object, List<Method>>> myMap = new ConcurrentHashMap<>();

    private PubSubLibrary() {
        //no-op
    }

    public static PubSubLibrary getInstance() {
        if (INSTANCE == null) {
            synchronized (PubSubLibrary.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PubSubLibrary();
                }
            }
        }

        return INSTANCE;
    }

    public void subscribe(Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Subscriber) {
                    if (method.getParameterCount() != 1) {
                        throw new RuntimeException("method annotated with Subscriber can only have one parameter");
                    } else {
                        Class<?> clazzz = method.getParameterTypes()[0];
                        synchronized (this) {
                            if (myMap.containsKey(clazzz)) {
                                Map<Object, List<Method>> mySecondMap = myMap.get(clazzz);
                                if (mySecondMap.containsKey(object)) {
                                    mySecondMap.get(object).add(method);
                                } else {
                                    List<Method> methodList = new ArrayList<>();
                                    methodList.add(method);
                                    mySecondMap.put(object, methodList);
                                }
                            } else {
                                Map<Object, List<Method>> map = new ConcurrentHashMap<>();
                                List<Method> methodList = new ArrayList<>();
                                methodList.add(method);
                                map.put(object, methodList);
                                myMap.put(clazzz, map);
                            }
                        }
                    }
                }
            }
        }
    }

    public <T> void publish(IEvent<T> event) throws Exception {
        if (event == null) {
            throw new NullPointerException("method argument can not be null!");
        }

        Class<?> clazz = event.getClass();
        synchronized (this) {
            if (myMap.containsKey(clazz)) {
                Map<Object, List<Method>> mySecondMap = myMap.get(clazz);
                for (Map.Entry<Object, List<Method>> entry : mySecondMap.entrySet()) {
                    Object object = entry.getKey();
                    List<Method> methodList = entry.getValue();
                    for (Method method : methodList) {
                        method.invoke(object, event);
                    }
                }
            } else {
                System.out.println("The event: " + clazz.toString() + " has no subscriber, thus no method has been invoked at this time");
            }
        }
    }
}

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PubSubLibrary {

    private static volatile PubSubLibrary INSTANCE = null;

    private Map<Class<?>, Map<Object, List<?>>> myMap = new ConcurrentHashMap<>();

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
                    System.out.println("Found one method annotated with Subscriber with name: " + method.getName());
                    if (method.getParameterCount() != 1) {
                        throw new RuntimeException("method annotated with Subscriber can only have one parameter");
                    } else {
                        Class<?> clazzz = method.getParameterTypes()[0];
                        if (myMap.containsKey(clazzz)) {

                        } else {

                        }
                    }
                }
            }
        }
    }

    public <T> void publish(IEvent<T> event) {
        if (event == null) {
            throw new NullPointerException("method argument can not be null!");
        }

        Class<?> clazz = event.getClass();


    }
}

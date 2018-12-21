import java.util.HashMap;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) {
        TestClassA testClassA = new TestClassA();
        TestClassB testClassB = new TestClassB();
        PubSubLibrary.getInstance().subscribe(testClassA);
        PubSubLibrary.getInstance().subscribe(testClassB);

    }
}

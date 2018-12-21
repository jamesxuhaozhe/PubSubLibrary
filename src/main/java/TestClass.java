import java.util.HashMap;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) throws Exception {
        //TestClassA testClassA = new TestClassA();
        //TestClassB testClassB = new TestClassB();

        //String data = PubSubLibrary.getInstance().getInternalData();

        TransactionCompleteEvent event1 = new TransactionCompleteEvent("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTt");

        DownloadFinishEvent event2 = new DownloadFinishEvent("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");


        //PubSubLibrary.getInstance().publish(event1);

        //PubSubLibrary.getInstance().publish(event2);

        TestClassC testClassC = new TestClassC();



    }
}

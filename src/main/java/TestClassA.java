public class TestClassA {

    public TestClassA() {
        PubSubLibrary.getInstance().subscribe(this);
    }
    @Subscriber
    public void testMethodA(TransactionCompleteEvent event) {
        System.out.println("receive transaction complete event!");
    }
}

public class TestClassA {

    public TestClassA() {
        PubSubLibrary.getInstance().subscribe(this);
    }
    @Subscriber
    public void testMethodA(TransactionCompleteEvent event) {
        System.out.println("receive transaction complete event from class A");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodA1(TransactionCompleteEvent event) {
        System.out.println("receive transaction complete event from class A");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodA2(DownloadFinishEvent event) {
        System.out.println("receive download finish event from class A");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodA3(DownloadFinishEvent event) {
        System.out.println("receive download finish event from class A");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodA4(IEvent event) {
        System.out.println("Received method!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}

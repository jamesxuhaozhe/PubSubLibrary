public class TestClassB {

    public TestClassB() {
        PubSubLibrary.getInstance().subscribe(this);
    }

    @Subscriber
    public void testMethodB(DownloadFinishEvent event) {
        System.out.println("Received download finish event from class B");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodB1(DownloadFinishEvent event) {
        System.out.println("Receive download finish event from class B");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodB2(TransactionCompleteEvent event) {
        System.out.println("Receive transaction complete event from class B");

        System.out.println(event.getData());
    }

    @Subscriber
    public void testMethodB3(TransactionCompleteEvent event) {
        System.out.println("Receive transaction complete event from class B");

        System.out.println(event.getData());
    }
}

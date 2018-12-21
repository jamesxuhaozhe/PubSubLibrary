public class TestClassB {

    public TestClassB() {
        PubSubLibrary.getInstance().subscribe(this);
    }

    @Subscriber
    public void testMethodB(DownloadFinishEvent event) {
        System.out.println("Received download finish event!");
    }

}

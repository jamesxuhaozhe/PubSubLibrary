public class TestClassC {

    public TestClassC() {
        PubSubLibrary.getInstance().subscribe(this);
    }

    @Subscriber
    public void testMethodC(IEvent event) {
        System.out.println("This should be called");
    }
}

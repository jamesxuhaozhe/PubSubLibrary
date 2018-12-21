public class TransactionCompleteEvent implements IEvent<String> {

    private String data;

    public TransactionCompleteEvent(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}

public class DownloadFinishEvent implements IEvent<String> {
    private String data;

    public DownloadFinishEvent(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}

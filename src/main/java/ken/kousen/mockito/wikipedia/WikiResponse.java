package ken.kousen.mockito.wikipedia;

@SuppressWarnings("unused")
public class WikiResponse {

    private String batchcomplete;
    private WikiQuery query;

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public WikiQuery getQuery() {
        return query;
    }

    public void setQuery(WikiQuery query) {
        this.query = query;
    }
}

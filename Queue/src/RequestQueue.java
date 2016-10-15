import java.util.LinkedList;
import java.util.List;

public class RequestQueue {

    private List<Request> requests = new LinkedList<Request>();

    public synchronized void putRequest(Request request) {
        requests.add(request);

    }

    public synchronized Request getRequest() {

        return requests.remove(0);

    }

    public int size() {
        return requests.size();
    }
}

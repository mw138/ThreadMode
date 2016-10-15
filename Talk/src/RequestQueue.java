import java.util.LinkedList;
import java.util.List;

/**
 * Author : maowei
 * Date   : 2016/10/6 0006
 */
public class RequestQueue {

    private LinkedList<Request> queue = new LinkedList<Request>();


    public synchronized void putRequest(Request request) {
        assert request != null;
        queue.addLast(request);
        notifyAll();
    }

    public synchronized Request getRequest() {
        while (queue.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.removeFirst();
    }

}

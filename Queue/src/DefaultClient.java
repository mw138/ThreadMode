import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
public class DefaultClient implements Client {

    private final RequestQueue requestQueue;

    private int idSequence = 0;

    public DefaultClient(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void sendRequest(Request request) {
        requestQueue.putRequest(request);
        System.out.println("send new request which id is [" + request.getId() + "]");

    }

    private Request createRequest() {
        return new Request(idSequence++);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (requestQueue) {
                try {
                    Request request = createRequest();
                    sendRequest(request);
                    requestQueue.notify();
                    Thread.sleep(new Random().nextInt(1000));
                    requestQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}

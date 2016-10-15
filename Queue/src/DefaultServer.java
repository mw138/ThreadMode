import java.util.Random;

/**
 * Author : maowei
 * Date   : 2016/10/4 0004
 */
public class DefaultServer implements Server {

    private final RequestQueue requestQueue;

    public DefaultServer(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void resolveRequest(Request request) {
        System.out.println("Resolve request which id is [" + request.getId() + "]");

    }

    @Override
    public void run() {
        while (true) {
            synchronized (requestQueue) {
                try {

                    Request request = requestQueue.getRequest();
                    resolveRequest(request);
                    Thread.sleep(new Random().nextInt(1000));
                    requestQueue.notify();
                    requestQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

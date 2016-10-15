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
                    while (requestQueue.size() <= 0) {
                        try {
                            requestQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    Request request = requestQueue.getRequest();
                    resolveRequest(request);
                    requestQueue.notify();
            }
        }

    }
}

/**
 * Author : maowei
 * Date   : 2016/10/6 0006
 */
public class Talker extends Thread {
    private final RequestQueue sendQueue;

    private final RequestQueue receiveQueue;

    public Talker(String threadName, RequestQueue sendQueue, RequestQueue receiveQueue) {
        super(threadName);
        this.sendQueue = sendQueue;
        this.receiveQueue = receiveQueue;
    }


    @Override
    public void run() {
        int i = 1;
        while (i-- > 0) {
            try {
                synchronized (receiveQueue) {
                    receiveQueue.wait();
                }
                Request receiveRequest = receive();
                Request sendRequest = createRequest(receiveRequest);
                send(sendRequest);
                synchronized (sendQueue) {
                    sendQueue.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    private Request receive() {
        Request request = receiveQueue.getRequest();
        System.out.println(this.getName() + ": receive new request which message is [ " + request + " ]");
        return request;
    }

    public void send(Request request) {
        sendQueue.putRequest(request);
        System.out.println(this.getName() + ": send new request which message is [ " + request + " ]");

    }

    private Request createRequest(Request request) {
        String message = request.getMessage() + "!";
        return new Request(message);
    }
}

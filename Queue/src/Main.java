/**
 * Author : maowei
 * Date   : 2016/10/4 0004
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        Thread client = new Thread(new DefaultClient(requestQueue));
        Thread server = new Thread(new DefaultServer(requestQueue));
        client.start();
        server.start();
    }
}

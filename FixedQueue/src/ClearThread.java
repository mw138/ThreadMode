public class ClearThread extends Thread {
    private FixedQueue queue;

    public ClearThread(FixedQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                queue.clear();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

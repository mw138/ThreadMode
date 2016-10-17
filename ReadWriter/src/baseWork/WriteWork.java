package baseWork;

public abstract class WriteWork extends Thread implements Work {

    private final GuardStrategy lock;

    public WriteWork(GuardStrategy lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.writeLock();
            try {
                work();
                System.out.println("写执行了");
            } finally {
                lock.writeUnlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

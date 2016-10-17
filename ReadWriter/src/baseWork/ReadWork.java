package baseWork;

public abstract class ReadWork extends Thread implements Work {

    private final GuardStrategy lock;

    public ReadWork(GuardStrategy lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.readLock();
            try {
                work();
                System.out.println("读执行了");
            } finally {
                lock.readUnlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

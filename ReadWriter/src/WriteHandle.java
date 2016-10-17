public abstract class WriteHandle extends Thread implements Work {

    private final ReadWriteLock lock;

    public WriteHandle(ReadWriteLock lock) {
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

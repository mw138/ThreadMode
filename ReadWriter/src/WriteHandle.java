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
            }finally {
                lock.writeUnlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

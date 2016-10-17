public abstract class ReadHandle extends Thread implements Work{

    private final ReadWriteLock lock;

    public ReadHandle(ReadWriteLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.readLock();
            try {
                work();
            }finally {
                lock.readUnlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}

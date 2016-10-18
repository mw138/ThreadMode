package baseData;

public class ReadWriteLock {

    private GuardStrategy guardStrategy;

    private final Object lock = new Object();

    public ReadWriteLock() {
        this.guardStrategy = new DefaultGuardStrategy();
    }

    public ReadWriteLock(GuardStrategy guardStrategy) {
        this.guardStrategy = guardStrategy;
    }


    public void readLock() throws InterruptedException {
        synchronized (lock) {
            guardStrategy.doBeforeReadWait();
            try {
                while (guardStrategy.readCondition()) {
                    System.out.println("读在等待");
                    lock.wait();
                }
            } finally {
                guardStrategy.doAfterReadWait();
            }
            System.out.println("加载了读锁");
            guardStrategy.doBeforeRead();
        }
    }

    public void readUnlock() {
        synchronized (lock) {
            guardStrategy.doAfterRead();
            lock.notifyAll();
            System.out.println("读锁释放了");

        }
    }


    public void writeLock() throws InterruptedException {
        synchronized (lock) {
            guardStrategy.doBeforeWriteWait();
            try {
                while (guardStrategy.writeCondition()) {
                    System.out.println("写在等待");
                    lock.wait();
                }
            } finally {
                guardStrategy.doAfterWriteWait();
            }
            System.out.println("加载了写锁");
            guardStrategy.doBeforeWrite();
        }
    }

    public void writeUnlock() {
        synchronized (lock) {
            guardStrategy.doAfterWrite();
            lock.notifyAll();
            System.out.println("写锁释放了");
        }
    }

    private static class DefaultGuardStrategy implements GuardStrategy {

        private int read = 0;

        private int write = 0;

        private int waitingWrite = 0;

        private int waitingReading = 0;

        private boolean writePreferred = true;

        private boolean readPreferred = false;

        @Override
        public void doBeforeReadWait() {
            waitingReading++;
        }

        @Override
        public void doAfterReadWait() {
            waitingReading--;
        }

        @Override
        public boolean readCondition() {
            return write > 0 || (writePreferred && waitingWrite > 0);
        }

        @Override
        public void doBeforeRead() {
            read++;
        }

        @Override
        public void doAfterRead() {
            read--;
            readPreferred = false;
            writePreferred = true;
        }

        @Override
        public void doBeforeWriteWait() {
            waitingWrite++;
        }

        @Override
        public void doAfterWriteWait() {
            waitingWrite--;
        }

        @Override
        public boolean writeCondition() {
            return write > 0 || read > 0 || (readPreferred && waitingReading > 0);
        }

        @Override
        public void doBeforeWrite() {
            write++;
        }

        @Override
        public void doAfterWrite() {
            write--;
            readPreferred = true;
            writePreferred = false;
        }
    }


}

public class ReadWriteLock {

    private int read = 0;

    private int write = 0;

    private int waitingWrite = 0;

    private int waitingReading = 0;

    private boolean writePreferred = true;

    private boolean readPreferred = false;

    public ReadWriteLock() {
    }


    private final Object lock = new Object();


    public void readLock() throws InterruptedException {
        synchronized (lock) {
            waitingReading++;
            try {
                while (write > 0 || (writePreferred && waitingWrite > 0)) {
                    lock.wait();
                }
            }finally {
                waitingReading--;
            }
            read++;
        }
    }

    public void readUnlock() {
        synchronized (lock) {
            read--;
            readPreferred = false;
            writePreferred = true;
            lock.notifyAll();
        }
    }


    public void writeLock() throws InterruptedException {
        synchronized (lock) {
            waitingWrite++;
            try {
                while (write > 0 || read > 0 || (readPreferred && waitingReading > 0)) {
                    lock.wait();
                }
            } finally {
                waitingWrite--;
            }
            write++;
        }
    }

    public void writeUnlock() {
        synchronized (lock) {
            write--;
            readPreferred = true;
            writePreferred = false;
            lock.notifyAll();
        }
    }

}

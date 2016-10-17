import static javafx.scene.input.KeyCode.T;

public class DefaultReadWriteLock implements ReadWriteLock {

    private int read = 0;

    private int write = 0;

    private int waitingWrite = 0;

    private int waitingReading = 0;

    private boolean writePreferred = true;

    private boolean readPreferred = false;

    public DefaultReadWriteLock() {
    }


    private final Object lock = new Object();


    public void readLock() throws InterruptedException {
        synchronized (lock) {
            waitingReading++;
            try {
                while (write > 0 || (writePreferred && waitingWrite > 0)) {
                    System.out.println("读在等待");
                    lock.wait();
                }
            }finally {
                waitingReading--;
            }
            System.out.println("加载了读锁");
            read++;
        }
    }

    public void readUnlock() {
        synchronized (lock) {
            read--;
            readPreferred = false;
            writePreferred = true;
            System.out.println("读锁释放了");
            lock.notifyAll();
        }
    }


    public void writeLock() throws InterruptedException {
        synchronized (lock) {
            waitingWrite++;
            try {
                while (write > 0 || read > 0 || (readPreferred && waitingReading > 0)) {

                    System.out.println("写在等待");

                    lock.wait();

                }
            } finally {
                waitingWrite--;
            }
            System.out.println("加载了写锁");

            write++;
        }
    }

    public void writeUnlock() {
        synchronized (lock) {
            write--;
            readPreferred = true;
            writePreferred = false;
            lock.notifyAll();
            System.out.println("写锁释放了");


        }
    }

}

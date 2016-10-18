package baseData;

public class Data {

    private final ReadWriteLock readWriteLock;

    private final ReadWriteStrategy readWriteStrategy;

    public Data() {
        this.readWriteStrategy = new DefaultReadWriteStrategy();
        this.readWriteLock = new ReadWriteLock();
    }

    public Data(GuardStrategy guardStrategy) {
        this.readWriteStrategy = new DefaultReadWriteStrategy();
        this.readWriteLock = new ReadWriteLock(guardStrategy);
    }

    public Data(ReadWriteStrategy readWriteStrategy) {
        this.readWriteStrategy = readWriteStrategy;
        this.readWriteLock = new ReadWriteLock();
    }

    public Data(GuardStrategy guardStrategy, ReadWriteStrategy readWriteStrategy) {
        this.readWriteLock = new ReadWriteLock(guardStrategy);
        this.readWriteStrategy = readWriteStrategy;
    }


    public void write(Object arg) throws InterruptedException {
        readWriteLock.writeLock();
        try {
            readWriteStrategy.doWrite(arg);
        } finally {
            readWriteLock.writeUnlock();
        }
    }

    public Object read() throws InterruptedException {
        readWriteLock.readLock();
        try {
            return readWriteStrategy.doRead();
        } finally {
            readWriteLock.readUnlock();
        }
    }

}

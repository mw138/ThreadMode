package baseWork;

public interface GuardStrategy {

    void readLock() throws InterruptedException;

    void readUnlock();

    void writeLock() throws InterruptedException;

    void writeUnlock();
}

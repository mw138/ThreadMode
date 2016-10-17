public class DataWrite<T> extends WriteHandle {

    private Data<T> data;

    private T t;

    public DataWrite(ReadWriteLock lock, Data<T> data, T t) {
        super(lock);
        this.t = t;
        this.data = data;
    }

    @Override
    public void work() {
        data.put(t);
    }
}

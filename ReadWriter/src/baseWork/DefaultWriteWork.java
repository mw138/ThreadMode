package baseWork;

public class DefaultWriteWork<T> extends WriteWork {

    private Data<T> data;

    private T t;

    public DefaultWriteWork(GuardStrategy lock, Data<T> data, T t) {
        super(lock);
        this.t = t;
        this.data = data;
    }

    @Override
    public void work() {
        data.put(t);
    }
}

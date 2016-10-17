package baseWork;

public class DefaultReadWork extends ReadWork {

    private Data data;

    public DefaultReadWork(Data data, GuardStrategy lock) {
        super(lock);
        this.data = data;
    }


    @Override
    public void work() {
        String s = data.get();
        System.out.println(s);
    }
}

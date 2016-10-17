public class DataRead extends ReadHandle {

    private Data data;

    public DataRead(Data data, ReadWriteLock lock) {
        super(lock);
        this.data = data;
    }


    @Override
    public void work() {
        String s = data.get();
        System.out.println(s);
    }
}

public class Cooker extends BaseWoke {

    private Table<Cake> table;
    private static int id;

    public Cooker(Table<Cake> table, String name) {
        super(name);
        this.table = table;
    }

    @Override
    public void work() {
        synchronized (Cooker.class) {
            Cake cake = new Cake(id++);
            table.put(cake);
        }
    }
}

public class Eater extends BaseWoke {

    private Table<Cake> table;

    public Eater(Table<Cake> table, String name) {
        super(name);
        this.table = table;
    }

    @Override
    public void work() {
        table.get();
    }
}

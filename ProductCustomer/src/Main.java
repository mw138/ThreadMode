import java.security.acl.Group;

public class Main {

    public static void main(String[] args) {
        int capacity = 3;
        Table<Cake> table = new Table<>(capacity);

        ThreadGroup cookerGroup = new ThreadGroup("cookerGroup");
        ThreadGroup eaterGroup = new ThreadGroup("eaterGroup");

        Cooker cooker1 = new Cooker(table,"cooker1");
        Cooker cooker2 = new Cooker(table,"cooker2");
        Eater eater1 = new Eater(table, "eater1");
        Eater eater2 = new Eater(table, "eater2");

        cookerGroup.addThread(cooker1);
        cookerGroup.addThread(cooker2);
        eaterGroup.addThread(eater1);
        eaterGroup.addThread(eater2);



        cookerGroup.start();
        eaterGroup.start();
    }


}

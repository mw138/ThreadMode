public class Case1 {
    public static void main(String[] args) throws InterruptedException {
        int capacity = 3;
        Table<Cake> table = new Table<>(capacity);

        ThreadGroup cookerGroup = new ThreadGroup("cookerGroup",3);
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

        Thread.sleep(1000);
        cooker1.interrupt();
        cooker2.interrupt();
        eater1.interrupt();
        eater2.interrupt();
// 1 捕获了InterruptedException异常, 继续循环则不能制止线程
// 2 加入sleep()使得线程可能被中断
    }
}

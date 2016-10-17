public class Case2 {

    public static void main(String[] args) throws InterruptedException {
        Case2Thread case2Thread = new Case2Thread();
        case2Thread.start();
        Thread.sleep(1000);
        case2Thread.interrupt();

    }

}

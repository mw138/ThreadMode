public class Main {

    public static void main(String[] args) {
        FixedQueue queue = new FixedQueue(5);
        new Maker(queue).start();
        new Customer(queue).start();
        new ClearThread(queue).start();
    }



}

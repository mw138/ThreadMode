public class Customer extends Thread {

    private FixedQueue queue;


    public Customer(FixedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String s = queue.get();

            System.out.println("customer  " + s);
        }

    }
}

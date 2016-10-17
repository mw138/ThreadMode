public class Case2Thread extends Thread {
    private int id = 1;

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println(this.isInterrupted());
                    throw new InterruptedException(" thread interrupted");
                }
                System.out.println("ID: [" + (id++) + "]");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class Maker extends Thread {
    private FixedQueue queue;
    private int id=1;

    public Maker(FixedQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            String content = "the id :" + id++;
            queue.put(content);
            System.out.println("marker  "+content);


        }
    }
}

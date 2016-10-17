public class FixedQueue {
    private String[] queue;

    private int head;

    private int tail;

    private int count;


    public FixedQueue(int capacity) {
        queue = new String[capacity];
        head = 0;
        tail = 0;
        count = 0;
    }

    public synchronized void put(String s) {
        while (count >= queue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue[tail] = s;
        tail = (++tail) % queue.length;
        count++;
        System.out.println("size " + count);
        notifyAll();
    }

    public synchronized String get() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = queue[head];
        head = (++head) % queue.length;
        count--;
        System.out.println("size " + count);

        notifyAll();
        return s;
    }

    public synchronized void clear() {
        int index = head;
        while (index % queue.length != tail) {
            System.out.println("clear queue: [" + queue[head] + "]");
            index++;
        }
        for (int i = 0; i < queue.length; i++) {
            queue[i] = null;
        }
        head = 0;
        tail = 0;
        count = 0;
        notifyAll();
    }
}

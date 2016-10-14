import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class Table<T> {

    private int capacity;

    private List<T> queue = new LinkedList<T>();

    public Table(int capacity) {
        this.capacity = capacity;
    }

    public synchronized T get() {
        while (queue.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        T o = queue.remove(0);
        System.out.println("Thread: " + Thread.currentThread().getName() + " [eat " + o + "] ,the size of table is " + size());
        return o;
    }

    public synchronized void put(T o) {
        while (queue.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        queue.add(o);
        System.out.println("Thread: " + Thread.currentThread().getName() + " [product " + o + "], the size of table is "+size());
    }


    public synchronized int  size() {
        Vector vector = new Vector();
        return queue.size();
    }




}

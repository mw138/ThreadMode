import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;

public class ThreadGroup {

    private final String name;

    private int times;

    private final boolean timesMode;

    public volatile boolean stop = false;

    private List<Thread> threads = new LinkedList<Thread>();


    public ThreadGroup(String name) {
        this.name = name;
        timesMode = false;
    }

    public ThreadGroup(String name, int times) {
        this.name = name;
        this.times = times;
        this.timesMode = true;
    }

    public boolean isStop() {
        return stop;
    }

    public String getName() {
        return name;
    }

    public void addThread(Grouped thread) {
        thread.setGroup(this);
        threads.add((Thread) thread);
    }

    public void stop() {
        this.stop = true;
    }

    public int getTimes() {
        return times;
    }

    int decreaseTimes() {
        synchronized (this) {
            return --times;
        }

    }

    boolean isTimesMode() {
        return timesMode;
    }


    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

}

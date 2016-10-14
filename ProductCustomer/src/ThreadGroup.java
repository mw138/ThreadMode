import java.util.LinkedList;
import java.util.List;

public class ThreadGroup {

    private final String name;

    private static int times;

    private final boolean timesMode;

    private boolean stop = false;

    private List<Thread> threads = new LinkedList<Thread>();

    public ThreadGroup(String name) {
        this.name = name;
        timesMode = false;
    }

    public ThreadGroup(String name, int times) {
        this.name = name;
        ThreadGroup.times = times;
        this.timesMode = true;
    }

    protected boolean isStop() {
        return stop;
    }

    protected String getName() {
        return name;
    }

    public void addThread(Grouped thread) {
        thread.setGroup(this);
        threads.add((Thread) thread);
    }

    public void stop() {
        this.stop = true;
    }

    public  int getTimes() {
        return times;
    }

    void decreaseTimes() {
        times--;
    }

    boolean getTimesMode() {
        return timesMode;
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public boolean checkTimes() {
        if (!timesMode) {
            return true;
        }
        return times > 0;
    }


}

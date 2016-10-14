public abstract class BaseWoke extends Thread implements Grouped {

    protected ThreadGroup group;

    public BaseWoke() {

    }

    public BaseWoke(String name) {
        super(name);
    }

    @Override
    public void setGroup(ThreadGroup group) {
        this.group = group;
    }

    @Override
    public void run() {
        while (!group.isStop() && group.checkTimes()) {
            group.decreaseTimes();
            work();
        }
    }

    abstract void work();


}

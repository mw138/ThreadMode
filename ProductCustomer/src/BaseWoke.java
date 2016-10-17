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

    /*
    * a 使用stop字段标记线程是否需要继续运行, stop字段默认false,有两种情况可以改变：
    *      1 用户调用stop()方法
    *      2 线程执行完了指定的次数， 调用stop()方法中止成功程序运行；
    * b 由于isStop()与work()之间的代码没有使用同步控制，这个意味着：
    *      1 调用stop()方法并没有立即中止运行中的任务， 而是等任务完成之后才结束线程；
    *      2 程序完成指定次数， 调用stop()方法时， 已经通过isStop()运行的线程不能够继续执行下去；
    * c 为了解决b.2中提到的问题， 所以要做二次判断： 通过decreaseTimes()进行次数验证， 保证通过isStop()方法的线程也不能够继续运行；
    *
    * d 程序执行完指定的次数后， 需要修改stop的状态， 这部分代码没有当道decreaseTimes()中运行， 是为了保证程序的易读性； 这部分逻辑由BaseWork完成；
    *
    * 扩展：
    *    1 为什么decreaseTimes()与 work()这两部分代码没有同步， 会不会出现 if...do 这样的线程安全问题：
    *        答： 不会。work()的执行不会改变再次执行decreaseTimes()的结果， 多以不需要同步；
    *    2 isStop() 与work()之间的代码为什么没有同步， 很明显isStop之后的代码会改变再次执行isStop()的结果， 会出现线程安全问题吗？
    *        答： 不会。的确， isStop()再次执行时结果会改变， 但是之后的代码由于decreaseTimes()的限制work()不会执行，stop()方法又是可以重复执行的， 所以不会影响程序的正确性；
    *
    *   3. 掌握3步二分法， if...do...change判断是否需要加入同步， 很重要！
    * */
    @Override
    public void run() {
        try {

            while (!group.isStop()) {
                Thread.sleep(1000);
                if (group.isTimesMode()) {
                    if (group.decreaseTimes() >= 0) {
                        work();
                    } else {
                        group.stop();
                    }
                } else {
                    work();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    abstract void work();


}

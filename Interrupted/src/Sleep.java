public class Sleep {

    public static void sleep(long millis) {
        if (millis != 0) {
            Object lock = new Object();
            synchronized (lock) {
                try {
                    lock.wait(millis);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

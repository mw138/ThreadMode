package baseData;

public class WriteThread extends Thread {

    private Data data;
    private char c;

    public WriteThread(Data data, char c) {
        this.data = data;
        this.c = c;
    }

    @Override
    public void run() {
        try {
            data.write(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

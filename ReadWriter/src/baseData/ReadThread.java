package baseData;

public class ReadThread extends Thread {

    private Data data;


    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            Object read = data.read();
            System.out.println(read);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

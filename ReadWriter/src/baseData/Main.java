package baseData;

public class Main {

    public static void main(String[] args) {
        Data data = new Data();

        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();

        new WriteThread(data, 'b').start();
        new WriteThread(data, 'c').start();
        new WriteThread(data, 'd').start();
    }

}

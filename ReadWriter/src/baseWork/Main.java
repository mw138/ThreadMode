package baseWork;

public class Main {

    public static void main(String[] args) {
        GuardStrategy lock = new DefaultGuardStrategy();
        Data<Character> data = new DefaultData();
        ReadWork read1 = new DefaultReadWork(data, lock);
        ReadWork read2 = new DefaultReadWork(data, lock);
        ReadWork read3 = new DefaultReadWork(data, lock);
        ReadWork read4 = new DefaultReadWork(data, lock);
        ReadWork read5 = new DefaultReadWork(data, lock);
        WriteWork write1 = new DefaultWriteWork<Character>(lock, data, 'b');
        WriteWork write2 = new DefaultWriteWork<Character>(lock, data, 'c');
        WriteWork write3 = new DefaultWriteWork<Character>(lock, data, 'd');
        WriteWork write4 = new DefaultWriteWork<Character>(lock, data, 'e');
        WriteWork write5 = new DefaultWriteWork<Character>(lock, data, 'f');


        write1.start();
        read3.start();
        write2.start();
        read1.start();
        write3.start();
        write4.start();
        read2.start();

    }

}

public class Main {

    public static void main(String[] args) {
        ReadWriteLock lock = new DefaultReadWriteLock();
        Data<Character> data = new CharData();
        ReadHandle read1 = new DataRead(data, lock);
        ReadHandle read2 = new DataRead(data, lock);
        ReadHandle read3 = new DataRead(data, lock);
        ReadHandle read4 = new DataRead(data, lock);
        ReadHandle read5 = new DataRead(data, lock);
        WriteHandle write1 = new DataWrite<Character>(lock, data, 'b');
        WriteHandle write2 = new DataWrite<Character>(lock, data, 'c');
        WriteHandle write3 = new DataWrite<Character>(lock, data, 'd');
        WriteHandle write4 = new DataWrite<Character>(lock, data, 'e');
        WriteHandle write5 = new DataWrite<Character>(lock, data, 'f');


        write1.start();
        read3.start();
        write2.start();
        read1.start();
        write3.start();
        write4.start();
        read2.start();

    }

}

package baseData;

public class DefaultReadWriteStrategy implements ReadWriteStrategy {

    private char[] buffer = new char[]{'a', 'a', 'a', 'a', 'a'};

    @Override
    public Object doRead() {
        StringBuilder sb = new StringBuilder();
        for (char c : buffer) {
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public void doWrite(Object arg) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (Character) arg;
        }
    }
}

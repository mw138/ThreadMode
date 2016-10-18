package baseData;

public interface ReadWriteStrategy {

    Object doRead();

    void doWrite(Object arg);

}

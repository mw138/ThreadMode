package baseData;

public interface GuardStrategy {

    void doBeforeReadWait();

    void doAfterReadWait();

    boolean readCondition();

    void doBeforeRead();

    void doAfterRead();

    void doBeforeWriteWait();

    void doAfterWriteWait();

    boolean writeCondition();

    void doBeforeWrite();

    void doAfterWrite();


}

/**
 * Created by Administrator on 2016/10/4 0004.
 */
public interface Server extends Runnable {

    void resolveRequest(Request request);
}

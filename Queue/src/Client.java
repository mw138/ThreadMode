/**
 * Created by Administrator on 2016/10/4 0004.
 */
public interface Client extends Runnable{

    void sendRequest(Request request);

}

/**
 * Author : maowei
 * Date   : 2016/10/6 0006
 */
public class Main {


    public static void main(String[] args) {

        RequestQueue talker1SendQueue = new RequestQueue();
        RequestQueue talker2SendQueue = new RequestQueue();
        Talker talker1 = new Talker("talker1",talker1SendQueue, talker2SendQueue);
        Talker talker2 = new Talker("talker2",talker2SendQueue, talker1SendQueue);
        talker1.start();
        talker2.start();
        talker1.send(new Request("!"));

    }
}

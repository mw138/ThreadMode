/**
 * Author : maowei
 * Date   : 2016/10/6 0006
 */
public class Request {

    public Request(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

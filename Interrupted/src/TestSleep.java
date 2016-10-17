public class TestSleep {

    public static void main(String[] args) {
        System.out.println("begin");
        System.out.println(System.currentTimeMillis());
        Sleep.sleep(10000);
        System.out.println("end");
        System.out.println(System.currentTimeMillis());
    }


}

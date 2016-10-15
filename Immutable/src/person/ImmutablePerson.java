package person;

public class ImmutablePerson {
    private final String name;

    private final String address;


    public ImmutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /*
    * 这里说明一下： 如果只是name或者address一个可变， 则不需要同步， 因为不存在线程安全的一个成对概念！
    * */

    public ImmutablePerson(MutablePerson mutablePerson) {
        synchronized (mutablePerson) {
            this.name = mutablePerson.getName();
            this.address = mutablePerson.getAddress();
        }
    }


    public MutablePerson getMutablePerson() {
        return new MutablePerson(this);
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

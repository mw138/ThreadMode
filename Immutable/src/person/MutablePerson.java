package person;

public class MutablePerson {

    private String name;

    private String address;

    public MutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public MutablePerson(ImmutablePerson immutablePerson) {
        this.name = immutablePerson.getName();
        this.address = immutablePerson.getAddress();
    }

    public synchronized ImmutablePerson getImmutablePerson() {
        return new ImmutablePerson(this);
    }

    public synchronized void setMutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    String getName() {
        return name;
    }

    String getAddress() {
        return address;
    }


}

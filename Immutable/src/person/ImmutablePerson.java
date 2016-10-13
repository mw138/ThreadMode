package person;

public class ImmutablePerson {
    private final String name;

    private final String address;


    public ImmutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

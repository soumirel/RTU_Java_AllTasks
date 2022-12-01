package rtu.task31;

public class Customer {

    private String firstName;

    private String secondName;

    private int age;

    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Customer(String firstName,
                    String secondName,
                    int age,
                    Address address)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }
}
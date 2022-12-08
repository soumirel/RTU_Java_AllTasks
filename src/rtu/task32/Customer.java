package rtu.task32;

import java.util.Random;

public class Customer {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;


    Customer MATURE_UNKNOWN_CUSTOMER() {
        int age = 18 + (int) (Math.random() * 91);
        return new Customer("Инкогнито", "Инкогнито", age, Address.EMPTY_ADDRESS());
    }

    Customer NOT_MATURE_UNKNOWN_CUSTOMER() {
        int age = 12 + (int) (Math.random() * 5);
        return new Customer("Инкогнито", "Инкогнито", age, Address.EMPTY_ADDRESS());
    }

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

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

    public static Customer RandomCustomer() {
        Random random = new Random();
        String[] firstNames = {
                "Алексей", "Иса", "Ислам",
                "Влад", "Стас", "Егор", "Женя"};
        String[] surnames = {
                "Мазанов", "Кушхов", "Алиев",
                "Насевич", "Поведенок", "Юсипов", "Слюсаренко"};
        return new Customer(
                firstNames[random.nextInt(firstNames.length)],
                surnames[random.nextInt(surnames.length)],
                14 + random.nextInt(99 - 14),
                Address.RandomAddress()
        );
    }
}


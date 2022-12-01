package rtu.task17;

public class Drink implements Item {
    private final String name;
    private final double price;
    private final String description;

    public Drink(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Drink(String name, String description) {
        this.price = 0;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return name + ", " + price + " $, " + description;
    }
}


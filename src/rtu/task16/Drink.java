package rtu.task16;

final public class Drink {
    final private int cost;
    final private String name;
    final private String description;

    final int zeroPrice = 0;

    public Drink(String name, String description) {
        this.name = name;
        this.description = description;
        this.cost = zeroPrice;
    }

    public Drink(int cost, String name, String description) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

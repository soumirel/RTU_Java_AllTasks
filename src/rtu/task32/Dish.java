package rtu.task32;

public class Dish implements MenuItem
{
    private final String name;
    private final double price;
    private final String description;

    public Dish(String name, double price, String description)
    {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Dish(String name, String description)
    {
        this.price = 0;
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return name + ", " + price + "$, " + description;
    }
}


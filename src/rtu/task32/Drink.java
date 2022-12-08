package rtu.task32;

public class Drink implements MenuItem, Alcoholable {
    private final String name;
    private final double price;
    private final String description;
    private final boolean isAlcoholic;
    private final double alcoholVol;
    private final DrinkTypeEnum type;


    public Drink() {
        this.alcoholVol = 0;
        this.type = null;
        this.price = 0;
        this.name = "";
        this.description = "";
        this.isAlcoholic = alcoholVol > 0;

    }

    public Drink(DrinkTypeEnum type, double alcoholVol, int price) {
        this.alcoholVol = alcoholVol;
        this.type = type;
        this.price = price;
        this.name = type.name();
        this.description = "";
        this.isAlcoholic = alcoholVol > 0;
    }

    public Drink(String name, double price, String description, boolean isAlcoholic, double alcoholVol) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.isAlcoholic = isAlcoholic;
        this.alcoholVol = alcoholVol;
        this.type = null;
    }

    public Drink(String name, String description, boolean isAlcoholic, double alcoholVol) {
        this.price = 0;
        this.name = name;
        this.description = description;
        this.isAlcoholic = isAlcoholic;
        this.alcoholVol = alcoholVol;
        this.type = null;
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
        if (isAlcoholic) {
            return name + ", " + price + "$, " + description + ", " + alcoholVol + "% alc";
        } else {
            return name + ", " + price + "$, " + description;
        }
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    @Override
    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public static Drink GetDrink(DrinkTypeEnum drinkType) {
        return switch (drinkType) {
            case BEER -> new Drink("Beer", 3.0, "beer", true, 5.0);
            case WINE -> new Drink("Wine", 5.5, "wine", true, 10.0);
            case VODKA -> new Drink("Vodka", 4.0, "vodka", true, 40.0);
            case BRANDY -> new Drink("Brandy", 6.5, "brandy", true, 40.0);
            case CHAMPAGNE -> new Drink("Champagne", 5.5, "champagne", true, 12.0);
            case WHISKEY -> new Drink("Whiskey", 7.0, "whiskey", true, 40.0);
            case TEQUILA -> new Drink("Tequila", 8.9, "tequila", true, 40.0);
            case RUM -> new Drink("Rum", 9.0, "rum", true, 40.0);
            case VERMOUTH -> new Drink("Vermouth", 10.9, "vermouth", true, 15.0);
            case LIQUOR -> new Drink("Liquor", 8.0, "liquor", true, 40.0);
            case JAGERMEISTER -> new Drink("Jagermeister", 12.0, "Jagermeister", true, 35.0);
            case JUICE -> new Drink("Juice", 2, "juice", false, 0.0);
            case COFFEE -> new Drink("Coffee", 3, "coffee", false, 0.0);
            case GREEN_TEA -> new Drink("Green tea", 2.5, "green tea", false, 0.0);
            case BLACK_TEA -> new Drink("Black tea", 2.0, "black tea", false, 0.0);
            case MILK -> new Drink("Milk", 2.0, "milk", false, 0.0);
            case WATER -> new Drink("Water", 1.0, "water", false, 0.0);
            case SODA -> new Drink("Soda", 1.9, "soda", false, 0.0);
        };
    }
}


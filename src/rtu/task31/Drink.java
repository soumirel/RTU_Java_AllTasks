package rtu.task31;

import java.util.Objects;

enum DrinkTypeEnum {
    BEER ("alco"),
    WINE("alco"),
    VODKA("alco"),
    BRANDY("alco"),
    CHAMPAGNE("alco"),
    WHISKEY("alco"),
    TEQUILA("alco"),
    RUM("alco"),
    VERMOUTH("alco"),
    LIQUOR("alco"),
    JAGERMEISTER("alco"),
    JUICE("nonAlco"),
    COFFEE("nonAlco"),
    GREEN_TEA("nonAlco"),
    BLACK_TEA("nonAlco"),
    MILK("nonAlco"),
    WATER("nonAlco"),
    SODA("nonAlco");

    private final String isAlco;
    DrinkTypeEnum(String isAlco) {
        this.isAlco = isAlco;
    }

    public boolean isAlco() {
        return Objects.equals(isAlco, "alco");
    }
}

final public class Drink extends MenuItem implements Alcoholable {

    final private double alcoholVol;

    final private DrinkTypeEnum type;

    public Drink(int cost, String name, String description, double alcoholVol, DrinkTypeEnum type) {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return type.isAlco();
    }

    @Override
    public double getAlcoholVolume() {
        return alcoholVol;
    }
}

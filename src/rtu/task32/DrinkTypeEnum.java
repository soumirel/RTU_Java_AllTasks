package rtu.task32;

public enum DrinkTypeEnum {
    BEER(3),
    WINE(12),
    VODKA(37),
    BRANDY(20),
    CHAMPAGNE(11.5),
    WHISKEY(40),
    TEQUILA(40),
    RUM(35),
    VERMOUTH(20),
    LIQUOR(30),
    JAGERMEISTER(35),
    JUICE,
    COFFEE,
    GREEN_TEA,
    BLACK_TEA,
    MILK,
    WATER,
    SODA;

    private final double alcoholVol;

    DrinkTypeEnum() {
        alcoholVol = 0;
    }

    DrinkTypeEnum(double alcoholVol) {
        this.alcoholVol = alcoholVol;
    }

    public double getAlcoholVol() {
        return alcoholVol;
    }
}


package rtu.task32_my;

import java.util.Random;

public class Address {
    private final String cityName;
    private final int zipCode;
    private final String streetName;
    private final int buildingNumber;
    private final char buildingLetter;
    private final int apartmentNumber;

    public static Address EMPTY_ADDRESS() {
        return new Address("Unknown", 0, "Unknown", 0, ' ', 0);
    }

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public static Address RandomAddress() {
        Random random = new Random();
        String[] cityNames = {
                "Рязань", "Москва", "Нальчик",
                "Элиста", "Мирный", "Вышгород",
                "Омск", "Сергиев Посад", "Грозный"};
        String[] streetNames = {
                "Пирогова", "Ленина", "Октябрьская",
                "Интернациональная", "Победы", "Высоковольтная",
                "Первомайская", "Советская"};
        String buildingLetter = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
        return new Address(cityNames[random.nextInt(cityNames.length)],
                random.nextInt(10000),
                streetNames[random.nextInt(streetNames.length)],
                random.nextInt(50),
                buildingLetter.charAt(random.nextInt(buildingLetter.length())),
                random.nextInt(50));
    }

    public String toString() {
        return String.format("г.%s, К:%d, ул.%s, д.%d%c, кв.%d",
                cityName, zipCode, streetName, buildingNumber, buildingLetter, apartmentNumber);
    }

    public Address(int apartmentNumber){
        this.apartmentNumber = apartmentNumber;
        cityName = null;
        zipCode = 0;
        streetName = null;
        buildingNumber = 0;
        buildingLetter = ' ';
    }

}


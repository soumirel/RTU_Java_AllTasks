package rtu.task10;


import java.util.StringTokenizer;

public class Address {
    String _country;
    String _region;
    String _city;
    String _street;
    String _house;
    String _building;
    String _apartment;

    enum parseType {
        SPLIT,
        TOKENIZER
    }

    Address(String fullAddress, parseType type) {
       if (type == parseType.SPLIT)
           addressSplitParse(fullAddress);
       if (type == parseType.TOKENIZER)
           addressTokenizerParse(fullAddress);

    }

    @Override
    public String toString() {
        return "Address{" +
                "_country='" + _country + '\'' +
                ", _region='" + _region + '\'' +
                ", _city='" + _city + '\'' +
                ", _street='" + _street + '\'' +
                ", _house='" + _house + '\'' +
                ", _building='" + _building + '\'' +
                ", _apartment='" + _apartment + '\'' +
                '}';
    }

    private void addressSplitParse(String fullAddress) {
        String[] addressArray = fullAddress.split(",");
        _country = addressArray[0].trim();
        _region = addressArray[1].trim();
        _city = addressArray[2].trim();
        _street = addressArray[3].trim();
        _house = addressArray[4].trim();
        _building = addressArray[5].trim();
        _apartment = addressArray[6].trim();
    }


    private void addressTokenizerParse(String fullAddress) {
        StringTokenizer tokenizedAddress = new StringTokenizer(fullAddress, ",.;-");
        _country = tokenizedAddress.nextToken().trim();
        _region = tokenizedAddress.nextToken().trim();
        _city = tokenizedAddress.nextToken().trim();
        _street = tokenizedAddress.nextToken().trim();
        _house = tokenizedAddress.nextToken().trim();
        _building = tokenizedAddress.nextToken().trim();
        _apartment = tokenizedAddress.nextToken().trim();
    }
}

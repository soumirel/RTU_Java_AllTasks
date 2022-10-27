package rtu.task12;

public class Main {
    public static void main(String[] args) {
        MobileNumber number = new MobileNumber("+1231234567890");
        System.out.println(number.getNormalNumber());
        MobileNumber number1 = new MobileNumber("88005553535");
        System.out.println(number1.getNormalNumber());
    }
}

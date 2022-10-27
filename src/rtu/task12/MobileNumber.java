package rtu.task12;

public class MobileNumber {
    String normalNumber;

    MobileNumber(String number) {
        if (number.charAt(0) == '+')
            normalNumber = parseInternationalNumber(number);
        if (number.charAt(0) == '8') {
            normalNumber = parseRussianNumber(number);
        }
    }

    private String parseInternationalNumber(String number) {
        String last = new StringBuilder() +
                number.substring(number.length() - 10, number.length());
        return new StringBuilder() + number.substring(0, number.length() - 10) +
                last.substring(0, 3) + "-" + last.substring(3, 6) +
                "-" + last.substring(6, 8) + "-" + last.substring(8, 10);
    }

    private String parseRussianNumber(String number) {
        return new StringBuilder() + "+7" +
                number.substring(1, 4) + "-" + number.substring(5, 7) +
                "-" + number.substring(7, 9) + "-" + number.substring(9, 11);
    }

    public String getNormalNumber() {
        return normalNumber;
    }
}

package rtu.task9;

import java.util.Scanner;

public class Main {
    public static void isValid(String TIN) {
        try {
            Integer.parseInt(TIN);
        } catch (NumberFormatException e) {
            throw new InvalidTINException("Invalid TIN");
        }
        int subjectCode = Integer.parseInt(TIN.substring(0, 2));
        boolean isCorrectSubjectCode = (subjectCode >= 1 && subjectCode <= 80)
                || subjectCode == 83 || (subjectCode >= 85 && subjectCode <= 87)
                || subjectCode == 89;
        if (TIN.length() != 10 || !isCorrectSubjectCode)
        {
            throw new InvalidTINException("Invalid TIN");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО");
        String name = scanner.nextLine();
        System.out.println("Введите ИИН");
        String TIN = scanner.nextLine();
        try {
            isValid(TIN);
            System.out.println("Данные корректны");
        }
        catch (InvalidTINException exception) {
            System.out.println("Некорректный ИНН");
        }
    }

}

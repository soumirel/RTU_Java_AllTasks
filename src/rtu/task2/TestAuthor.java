package rtu.task2;

import java.util.Objects;
import java.util.Scanner;

public class TestAuthor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Работа метода, демонстрирующего работу класса Author:");
        System.out.println("Введите имя автора:");
        String name = sc.nextLine();
        System.out.println("Введите эл.почту автора:");
        String email = sc.nextLine();
        System.out.println("Введите пол автора в формате \"М\"/\"Ж\":");
        String gender = sc.nextLine();
        while ((!Objects.equals(gender, "М")) && (!Objects.equals(gender, "Ж")))
        {
            System.out.println("Введено недопустимое значение! Повторите ввод: ");
            gender = sc.nextLine();
        }
        Author newAuthor = new Author(name, email, gender.toCharArray()[0]);
        System.out.println("Известная информация об авторе: " + newAuthor);

        System.out.println("Возможные действия:\n1.Сменить почту автора.\n2.Узнать известную информацию об авторе.");
        System.out.println("Введите номер выбранного варианта:");
        int userChoice = sc.nextInt();
        sc.nextLine();
        while (userChoice != 1 && userChoice != 2)
        {
            System.out.println("Введено недопустимое значение! Повторите ввод: ");
            userChoice = sc.nextInt();
        }
        if (userChoice == 1)
        {
            System.out.println("Введите новую почту:");
            newAuthor.setEmail(sc.nextLine());
        }
        else if (userChoice == 2)
        {
            System.out.println("Известная информация об авторе: " + newAuthor);
        }
    }
}

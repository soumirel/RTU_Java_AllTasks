package rtu.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1 - com.task1.Book Class");
        Book book = new Book();

        Scanner sc = new Scanner(System.in);
        String inputVar = "";

        System.out.println("Введите название книги:");
        inputVar = sc.nextLine();
        if (inputVar != "")
            book.setName(inputVar);

        System.out.println("Введите автора:");
        inputVar = sc.nextLine();
        if (inputVar != "")
            book.setAuthor(inputVar);

        System.out.println("Введите кол-во страниц (если неизвестно, введите \"0\")");
        book.setPages(sc.nextInt());
        sc.nextLine();

        System.out.println(book);

        System.out.println("Напишите отзыв о книге");
        inputVar = sc.nextLine();
        if (inputVar != "")
            book.makeReview(inputVar);

        System.out.println("Известная информация о вашей книге:\n" + book);
        System.out.println("Примерное количество слов в книге: " + book.showTotalWords());
    }
}

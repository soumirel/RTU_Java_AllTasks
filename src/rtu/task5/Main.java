package rtu.task5;

//14. Цифры числа слева направо
//Дано натуральное число N. Выведите все его цифры по одной, в обычном
//порядке, разделяя их пробелами или новыми строками.
//При решении этой задачи нельзя использовать строки, списки, массивы (ну
//и циклы, разумеется). Разрешена только рекурсия и целочисленная арифметика

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printNumber(num);
    }

    private static void printNumber(int num)
    {
        if (num % 10 == num)
            System.out.print(num + " ");
        if (num / 10 == 0)
            return;
        printNumber(num / 10);
        System.out.print(num % 10 + " ");
    }
}

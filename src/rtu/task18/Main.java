package rtu.task18;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateInt(-10,10);
        }
        printArray(array);
        Sort(array);
        printArray(array);
    }

    private static int generateInt(int left, int right) {
        return (int)(( Math.random() * (right - left + 1) + left));
    }

    private static void Sort(int[] array) {
        int j;
        int swap;
        for (int i = 1; i < array.length; i++) {
            swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

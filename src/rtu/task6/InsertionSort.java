package rtu.task6;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertionSort {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("Стас", 123),
                new Student("Надя", 321),
                new Student("Влад", 90),
                new Student("Лёха", 1009),
                new Student("Иса", 228),
                new Student("Ислам", 1337)
        };

        Sort(students);

        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getID());
        }
    }

    private static void Sort(Student[] sortArr) {
        int j;
        for (int i = 1; i < sortArr.length; i++) {
            Student swap = sortArr[i];
            for (j = i; j > 0 && swap.getID() < sortArr[j - 1].getID(); j--) {
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }
}


package rtu.task7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        drunkard();
    }

    private static void drunkard()
    {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> firstPlayer = new LinkedList<>();
        Queue<Integer> secondPlayer = new LinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            if (i <= 4) {
                firstPlayer.offer(scanner.nextInt());
            }
            else {
                secondPlayer.offer(scanner.nextInt());
            }
        }
        int counter = 0;
        while (counter <= 106)
        {
            counter++;

            if ((firstPlayer.peek() > secondPlayer.peek() &&
                    secondPlayer.peek() != 0 )||
                    firstPlayer.peek() == 0) {
                firstPlayer.offer(firstPlayer.poll());
                firstPlayer.offer(secondPlayer.poll());
            }
            else {
                secondPlayer.offer(firstPlayer.poll());
                secondPlayer.offer(secondPlayer.poll());
            }

            if (firstPlayer.peek() == null)
            {
                System.out.println("second " + counter);
                return;
            }
            if (secondPlayer.peek() == null)
            {
                System.out.println("first " + counter);
                return;
            }
        }

        System.out.println("botva");

    }
}

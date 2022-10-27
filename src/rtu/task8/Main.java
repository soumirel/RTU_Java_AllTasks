package rtu.task8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        WaitList<Integer> waitList = new WaitList<>();
        waitList.add(5);
        waitList.add(10);
        waitList.add(15);
        System.out.println(waitList);

        waitList.add(20);
        System.out.println(waitList);
        System.out.println(waitList.remove());
        System.out.println(waitList.isEmpty());
        System.out.println(waitList.contains(5));
        System.out.println(waitList.containsAll(
                Arrays.asList(10, 15)
        ));
        waitList.remove();
        waitList.remove();
        waitList.remove();
        System.out.println(waitList.isEmpty());

        BoundedWaitList<Integer> boundedWaitList =
                new BoundedWaitList<Integer>(5);
        for (int i = 50; i > (50 - 5) / 5; i -= 5) {
            boundedWaitList.add(i);
        }

        System.out.println(boundedWaitList);
        System.out.println(boundedWaitList.getCapacity());
        boundedWaitList.add(0);
        System.out.println(boundedWaitList);

        UnfairWaitList<Integer> unfairWaitList =
                new UnfairWaitList<>();
        for (int i = 1; i < 10; i++) {
            unfairWaitList.add(i);
        }
        System.out.println(unfairWaitList);
        for (int i = 1; i < 10; i++) {
            unfairWaitList.moveToBack(i);
            System.out.println(unfairWaitList);
        }
        unfairWaitList.remove(1);
        System.out.println(unfairWaitList);
    }
}

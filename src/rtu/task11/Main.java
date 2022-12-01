package rtu.task11;

public class Main {
    public static void main(String[] args) {
        testArrayQueueADT();
        testArrayQueueModule();
        testArrayQueue();
    }

    public static void testArrayQueueADT() {

        System.out.println("TestArrayQueueADT");
        ArrayQueueADT queue = new ArrayQueueADT();

        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        printArrayQueueADT(queue);
        System.out.println("-------");
        while (!ArrayQueueADT.isEmpty(queue)) {
            System.out.println(
                    ArrayQueueADT.size(queue) + " " + ArrayQueueADT.element(queue) + " " + ArrayQueueADT.dequeue(queue));
        }
        System.out.println("isEmpty: " + ArrayQueueADT.isEmpty(queue));
        System.out.println("-------");
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        printArrayQueueADT(queue);
        System.out.println("-------");
        ArrayQueueADT.clear(queue);
        System.out.println("isEmpty: " + ArrayQueueADT.isEmpty(queue));
        System.out.println("-------");
    }

    public static void printArrayQueueADT(ArrayQueueADT queue) {
        Object[] arr = ArrayQueueADT.toArray(queue);
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void printArrayQueue(ArrayQueue queue) {
        Object[] arr = queue.toArray();
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void printArrayQueueModule(ArrayQueueModule queue) {
        Object[] arr = queue.toArray();
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }


    public static void testArrayQueue() {
        System.out.println("TestArrayQueue");
        ArrayQueue queue = new ArrayQueue();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        printArrayQueue(queue);
        System.out.println("-------");
        while (!queue.isEmpty()) {
            System.out.println(
                    queue.size() + " " + queue.element() + " " + queue.dequeue());
        }
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("-------");
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        printArrayQueue(queue);
        System.out.println("-------");
        queue.clear();
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("-------");
    }

    public static void testArrayQueueModule() {
        System.out.println("TestArrayQueueModule");
        ArrayQueueModule queue = new ArrayQueueModule();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        printArrayQueueModule(queue);
        System.out.println("-------");
        while (!queue.isEmpty()) {
            System.out.println(
                    queue.size() + " " + queue.element() + " " + queue.dequeue());
        }
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("-------");
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        printArrayQueueModule(queue);
        System.out.println("-------");
        queue.clear();
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println("-------");
    }
}

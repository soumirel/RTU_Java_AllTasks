package rtu.task11;

public class Main {
    public static void main(String[] args) {
        testArrayQueue();
        System.out.println();
        testArrayQueueADT();
        System.out.println();
        testArrayQueueModule();
    }

    public static void testArrayQueue(){
        System.out.println("Тест ArrayQueue");
        ArrayQueue queue = new ArrayQueue();
        System.out.println("Заполнение");
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("ArrayQueue: ");
        queue.print();
        System.out.println();
        System.out.println("размер = " + queue.size());
        System.out.println("Достать первый");
        queue.dequeue();
        System.out.println("ArrayQueue: ");
        queue.print();
        System.out.println();
        System.out.println("размер = " + queue.size());
        System.out.println("Очистка");
        queue.clear();
        System.out.println("ArrayQueue: ");
        queue.print();
        System.out.println("размер = " + queue.size());
    }

    public static void testArrayQueueADT(){
        System.out.println("Тест ArrayQueueADT");
        ArrayQueueADT queue = new ArrayQueueADT();
        System.out.println("Заполнение");
        for (int i = 0; i < 5; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        System.out.println("ArrayQueueADT: ");
        ArrayQueueADT.print(queue);
        System.out.println();
        System.out.println("размер = " + ArrayQueueADT.size(queue));
        System.out.println("Достать первый");
        ArrayQueueADT.dequeue(queue);
        System.out.println("ArrayQueueADT: ");
        ArrayQueueADT.print(queue);
        System.out.println();
        System.out.println("размер = " + ArrayQueueADT.size(queue));
        System.out.println("Очистка");
        ArrayQueueADT.clear(queue);
        System.out.println("ArrayQueueADT: ");
        ArrayQueueADT.print(queue);
        System.out.println("размер = " + ArrayQueueADT.size(queue));
    }

    public static void testArrayQueueModule(){
        System.out.println("Тест ArrayQueueModule");
        System.out.println("Заполнение");
        for (int i = 0; i < 5; i++) {
            ArrayQueueModule.enqueue(i);
        }
        System.out.println("ArrayQueueModule: ");
        ArrayQueueModule.print();
        System.out.println();
        System.out.println("размер = " + ArrayQueueModule.size());
        System.out.println("Достать первый");
        ArrayQueueModule.dequeue();
        System.out.println("ArrayQueueModule: ");
        ArrayQueueModule.print();
        System.out.println();
        System.out.println("размер = " + ArrayQueueModule.size());
        System.out.println("Очистка");
        ArrayQueueModule.clear();
        System.out.println("ArrayQueueModule: ");
        ArrayQueueModule.print();
        System.out.println("размер = " + ArrayQueueModule.size());
    }
}

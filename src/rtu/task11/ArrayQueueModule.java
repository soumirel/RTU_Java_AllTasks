package rtu.task11;

public class ArrayQueueModule {
    private static final int CAPACITY = 100;
    private static Object[] arrayQueueModule = new Object[CAPACITY];
    private static int size;
    private static int head;
    private static int tail;

    private static void checkCapacity(int capacity) {
        if (capacity >= arrayQueueModule.length) {
            Object[] temp = new Object[arrayQueueModule.length * 2];

            int count = tail < head ? arrayQueueModule.length - head : size;
            System.arraycopy(arrayQueueModule, head, temp, 0, count);
            if (tail < head)
                System.arraycopy(arrayQueueModule, 0, temp, count, tail);
            arrayQueueModule = temp;
            head = 0;
            tail = size;
        }
    }

    public static void enqueue(Object element) {
        checkCapacity(size + 1);
        arrayQueueModule[tail] = element;
        tail = (tail + 1) % arrayQueueModule.length;
        size++;
    }

    public static Object element() {
        return arrayQueueModule[head];
    }

    public static Object dequeue() {
        Object result = element();
        arrayQueueModule[head] = null;
        size--;
        head = (head + 1) % arrayQueueModule.length;
        return result;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        size = head = tail = 0;
        arrayQueueModule = new Object[CAPACITY];
    }

    public static void print(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        for(int i = head; i<head+size; i++) {
            System.out.print(arrayQueueModule[i] + " ");
        }
    }
}
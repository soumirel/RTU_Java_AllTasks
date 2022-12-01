package rtu.task11;

public class ArrayQueueADT {
    private static final int CAPACITY = 10;
    private Object[] arrayQueueADT;
    private int size;
    private int head;
    private int tail;

    public ArrayQueueADT() {
        arrayQueueADT = new Object[CAPACITY];
        size = head = tail = 0;
    }

    private static void checkCapacity(ArrayQueueADT adt, int capacity) {
        if (capacity >= adt.arrayQueueADT.length) {
            Object[] temp = new Object[adt.arrayQueueADT.length * 2];

            int count = adt.tail < adt.head ? adt.arrayQueueADT.length - adt.head : adt.size;
            System.arraycopy(adt.arrayQueueADT, adt.head, temp, 0, count);
            if (adt.tail < adt.head)
                System.arraycopy(adt.arrayQueueADT, 0, temp, count, adt.tail);
            adt.arrayQueueADT = temp;
            adt.head = 0;
            adt.tail = adt.size;
        }
    }

    public static void enqueue(ArrayQueueADT adt, Object element) {
        checkCapacity(adt, adt.size + 1);
        adt.arrayQueueADT[adt.tail] = element;
        adt.tail = (adt.tail + 1) % adt.arrayQueueADT.length;
        adt.size++;
    }

    public static Object element(ArrayQueueADT adt) {
        return adt.arrayQueueADT[adt.head];
    }

    public static Object dequeue(ArrayQueueADT adt) {
        Object result = element(adt);
        adt.arrayQueueADT[adt.head] = null;
        adt.size--;
        adt.head = (adt.head + 1) % adt.arrayQueueADT.length;
        return result;
    }

    public static int size(ArrayQueueADT adt) {
        return adt.size;
    }

    public static boolean isEmpty(ArrayQueueADT adt) {
        return adt.size == 0;
    }

    public static void clear(ArrayQueueADT adt) {
        adt.size = adt.head = adt.tail = 0;
        adt.arrayQueueADT = new Object[CAPACITY];
    }

    public static void print(ArrayQueueADT adt){
        if(isEmpty(adt)){
            System.out.println("Empty");
            return;
        }
        for(int i = adt.head; i<adt.head+adt.size; i++) {
            System.out.print(adt.arrayQueueADT[i] + " ");
        }
    }
}
package rtu.task11;

public class ArrayQueue {
    private final int CAPACITY = 10;
    private Object[] arrayQueue;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue() {
        arrayQueue = new Object[CAPACITY];
        size = head = tail = 0;
    }

    private void checkCapacity(int capacity) {
        if (capacity >= arrayQueue.length) {
            Object[] temp = new Object[arrayQueue.length * 2];

            int count = tail < head ? arrayQueue.length - head : size;
            System.arraycopy(arrayQueue, head, temp, 0, count);
            if (tail < head)
                System.arraycopy(arrayQueue, 0, temp, count, tail);
            arrayQueue = temp;
            head = 0;
            tail = size;
        }
    }

    public void enqueue(Object element) {
        checkCapacity(size + 1);
        arrayQueue[tail] = element;
        tail = (tail + 1) % arrayQueue.length;
        size++;
    }

    public Object element() {
        return arrayQueue[head];
    }

    public Object dequeue() {
        Object result = element();
        arrayQueue[head] = null;
        size--;
        head = (head + 1) % arrayQueue.length;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = head = tail = 0;
        arrayQueue = new Object[CAPACITY];
    }

    public  void print(){
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        for(int i = head; i<head+size; i++) {
            System.out.print(arrayQueue[i] + " ");
        }
    }
}
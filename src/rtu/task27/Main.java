package rtu.task27;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 27");
        Integer[] array1 = {1, 2, 3};
        String[] array2 = {"s1", "s2", "s3"};

        System.out.println("arra1[0] = " + get(array1, 0));
        System.out.println("arra2[1] = " + get(array2, 1));
        System.out.println("arra2[4]: " + get(array2, 4));
    }

    private static <T> T get(T[] array, int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= array.length){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}


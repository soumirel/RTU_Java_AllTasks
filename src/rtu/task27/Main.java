package rtu.task27;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        String[] array2 = {"str1", "str2", "str3"};
        Double[] array3 = {1.1, 2.2, 3.3};
        System.out.println("array1[0] = " + get(array1, 0));
        System.out.println("array2[1] = " + get(array2, 1));
        System.out.println("array3[1]: " + get(array3, 1));
        try {
            System.out.println("array3[4]: " + get(array3, 4));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array3[4]: " + e.getMessage());
        }
    }

    private static <T> T get(T[] array, int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= array.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }
}


package rtu.task24;

import java.util.ArrayList;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) {
        testArrayList();
    }

    private static void testArrayList() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Алексей");
        names.add( "Иван");
        names.add("Станислав");
        names.add(0, "Владислав");
        names.add("Надежда");
        names.add(1,"Алина");

        System.out.println("В списке " + names.size() + " элементов:");
        for(String name : names){
            System.out.println(name);
        }
        System.out.println();

        if(names.contains("Алина")){
            System.out.println("Список содержит имя Алина");
        }
        else{
            System.out.println("Список не содержит имя Алина");
        }
        if(!names.contains("Дмитрий")){
            System.out.println("Список не содержит имя Дмитрий");
        }
        else{
            System.out.println("Список содержит имя Дмитрий");
        }

        System.out.println("Удаление имени Владислав");
        names.remove("Владислав");
        System.out.println("Удаление первого элемента списка - " + names.get(0));
        names.remove(0);
        System.out.println("Удаление последнего элемента списка - " + names.get(names.size() - 1));
        names.remove(names.size() - 1);

        System.out.println();

        System.out.println("В списке " + names.size() + " элементов:");
        for(String city : names){
            System.out.println(city);
        }
    }
}


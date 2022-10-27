package rtu.task21;

public class Main {
    public static void main(String[] args) {
        Nameable nameable1 = new Woman("Вовчик");
        Nameable nameable2 = new Human("Чебурашка");
        Nameable nameable3 = new Dog("Анастасия");
        System.out.println(nameable1.getName());
        System.out.println(nameable2.getName());
        System.out.println(nameable3.getName());
    }
}

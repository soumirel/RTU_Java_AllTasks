package rtu.task3.subtask2;

public class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle("red", false, 1.2, 2.0);
        System.out.println(rec);
        Square sq = new Square(10, "green", true);
        System.out.println(sq);
        Circle cl = new Circle(5.5, "blue", false);
        System.out.println(cl);
    }
}

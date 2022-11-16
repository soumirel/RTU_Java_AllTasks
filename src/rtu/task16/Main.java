package rtu.task16;

public class Main {
    public static void main(String[] args) {
        Drink drink1 = new Drink("Juice", "Just juice");
        System.out.println("Name: " + drink1.getName() +
                " Description: " + drink1.getDescription() +
                " Cost: " + drink1.getCost());
        Drink drink2 = new Drink(50, "Milk", "Just milk");
        System.out.println("Name: " + drink2.getName() +
                " Description: " + drink2.getDescription() +
                " Cost: " + drink2.getCost());
    }
}

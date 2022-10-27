package rtu.task19;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human);

        human.rightLeg.bend();
        human.leftHand.bend();
        human.head.rotate(Orientation.LEFT);
        System.out.println(human);

        human.rightLeg.bend();
        human.leftHand.bend();
        human.head.rotate(Orientation.RIGHT);
        System.out.println(human);
    }
}

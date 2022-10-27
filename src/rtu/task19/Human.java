package rtu.task19;

enum Orientation {
    LEFT,
    RIGHT
}

public class Human {
    Head head;
    Leg leftLeg;
    Leg rightLeg;
    Hand leftHand;
    Hand rightHand;

    Human() {
        head = new Head();
        leftHand = new Hand(Orientation.LEFT);
        rightHand = new Hand(Orientation.RIGHT);
        leftLeg = new Leg(Orientation.LEFT);
        rightLeg = new Leg(Orientation.RIGHT);
    }

    @Override
    public String toString() {
        return "Человек:\n" +
                "Голова " + head + "; " +
                "Рука " + leftHand + "; " +
                "Рука " + rightHand + "; " +
                "Нога " + leftLeg + "; " +
                "Нога " + rightLeg;
    }
}

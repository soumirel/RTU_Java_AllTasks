package rtu.task14;

public class VictorianChair implements Chair {
    private int age;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "VictorianChair{" +
                "age=" + age +
                '}';
    }

    public VictorianChair(int age) {
        this.age = age;
    }
}

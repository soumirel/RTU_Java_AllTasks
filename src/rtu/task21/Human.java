package rtu.task21;

public class Human implements Nameable{
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

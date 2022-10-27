package rtu.task21;

public class Woman implements Nameable{
    String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

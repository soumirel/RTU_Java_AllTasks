package rtu.task20;

public abstract class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void bark() {
        System.out.println("Bark! Bark!");
    }
    @Override
    public String toString() {
        return "Я " + name + ", могу " + doSomethingSpecial();
    }

    public abstract String doSomethingSpecial();
}



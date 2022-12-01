package rtu.task13;

public class Test {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();
        Complex complex = factory.createComplex();
        System.out.println(complex);
        complex = factory.createComplex(5, 31);
        System.out.println(complex);
        complex = factory.createComplex(0, 10);
        System.out.println(complex);
        complex = factory.createComplex(-7, 0);
        System.out.println(complex);
        complex = factory.createComplex(0, 0);
        System.out.println(complex);
    }
}

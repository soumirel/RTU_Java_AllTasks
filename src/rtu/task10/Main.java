package rtu.task10;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Махатма", "Ганди", "Станиславович");
        System.out.println(person);
        System.out.println(person.getInitials());

        Person person1 = new Person("Стасислав");
        System.out.println(person1);
        System.out.println(person1.getInitials());

        Address address = new Address("Россия, Москва, Москва, пр. Вернадского, 78, -, ИВЦ-101", Address.parseType.SPLIT);
        System.out.println(address);

        Address address1 = new Address("Индия, Кодерский. Кодский; Кодск - Кодерская, 69. 9; 337", Address.parseType.TOKENIZER);
        System.out.println(address1);
    }
}

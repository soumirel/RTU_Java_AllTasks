package rtu.task10;

public class Main {
    public static void main(String[] args) {

        Address address = new Address("Россия, Москва, Москва, пр. Вернадского, 78, -, ИВЦ-101", Address.parseType.SPLIT);
        System.out.println(address);

        Address address1 = new Address("Индия, Кодский. Кодск; Кодерская - 69, 9. 337", Address.parseType.TOKENIZER);
        System.out.println(address1);
    }
}

package rtu.task30;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 30");
        String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{8,}";
        //?=шаблон - позитивный просмотр вперед
        //.* - любое количество символов
        Pattern pattern = Pattern.compile(regex);
        TestRegex("F032_Password", pattern);
        TestRegex("TrySpy11", pattern);
        TestRegex("smart_pass", pattern);
        TestRegex("A007", pattern);
    }

    private static void TestRegex(String text, Pattern pattern){
        System.out.println("Expression " + text + " is " + (pattern.matcher(text).matches() ? "correct" : "incorrect"));
    }
}

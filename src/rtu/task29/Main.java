package rtu.task29;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex = "abcdefghijklmnopqrstuv18340";
        Pattern pattern = Pattern.compile(regex);
        TestRegex("abcdefghijklmnopqrstuv18340", pattern);
        TestRegex("eggdflkgnjdflkgjndflkj18340", pattern);
    }

    private static void TestRegex(String text, Pattern pattern){
        System.out.println("Expression " + text + " is " + (pattern.matcher(text).matches() ? "correct" : "incorrect"));
    }
}

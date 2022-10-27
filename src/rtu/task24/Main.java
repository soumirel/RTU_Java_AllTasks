package rtu.task24;

import java.util.ArrayList;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {
        new TestArrayList();
    }
}

class Letter implements Comparable<Letter> {
    private char l;

    public Letter(char l) {
        this.l = l;
    }

    public char getL() {
        return l;
    }

    @Override
    public int compareTo(Letter o) {
        return Character.compare(l, o.l);
    }

    @Override
    public String toString() {
        return Character.toString(l);
    }
}

class TestArrayList {
    public TestArrayList() {
        ArrayList<Letter> alphabet = new ArrayList<Letter>();
        Letter startLetter = new Letter('Z');
        for (int i = 0; i < 26; i++) {
            alphabet.add(new Letter((char) (startLetter.getL() - i)));
        }
        PrintList(alphabet);

        sort(alphabet);
        PrintList(alphabet);

        for (int i = 0; i < alphabet.size() / 2; i++) {
            alphabet.remove(i);
        }
        PrintList(alphabet);

        System.out.println(alphabet.subList(0, alphabet.size() / 2));

        for (int i = 0; i < alphabet.size(); i++) {
            alphabet.set(i, new Letter('A'));
        }

        PrintList(alphabet);
    }

    private void PrintList(ArrayList<Letter> arrayList) {
        for (Letter letter : arrayList) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }
}

package rtu.task1;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private int pages;

    private String review = null;

    Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    Book() {
        this.name = "Неизвестное название";
        this.author = "Неизвестный автор";
        this.pages = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Название книги: " + this.name +
                "\nАвтор: " + this.author +
                "\nКоличество страниц: " + this.pages +
                "\nВаш отзыв: " + this.showReview();
    }

    private int countTotalWords() {
        int averageWordsAtPage = 350;
        return 350 * this.pages;
    }

    public String showTotalWords() {
        if (pages != 0) {
            return "" + this.countTotalWords();
        }
        return "Подсчёт примерного кол-ва слов невозможен";
    }

    public void makeReview(String s){
        this.review = s;
    }

    private String showReview() {
        if (review == null) {
            return "Вы ещё не давали отзыв";
        }
        return this.review;
    }
}

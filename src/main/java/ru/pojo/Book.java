package ru.pojo;

public class Book {
    private String name;
    private int pageCount;

    public Book(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpageCount() {
        return pageCount;
    }

    public void setpageCount(int numberOfPages) {
        this.pageCount = numberOfPages;
    }
}

package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Война миров", 300),
                new Book("Clean code", 700),
                new Book("20 тысяч лье под водой", 450),
                new Book("Три мушкетера", 2001)
        };

        System.out.println("Изначальный список книг:");
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getpageCount());
        }

        System.out.println("Меняю местами список книг:");
        Book change = books[0];
        books[0] = books[books.length - 1];
        books[books.length - 1] = change;

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getpageCount());
        }

        System.out.println("Вывожу Clean code если есть:");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getpageCount());
                break;
            }
        }
    }
}

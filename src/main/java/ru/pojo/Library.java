package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Война миров", 300);
        Book book2 = new Book("Clean code", 700);
        Book book3 = new Book("20 тысяч лье под водой", 450);
        Book book4 = new Book("Три мушкетера", 2001);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book all = books[i];
            System.out.println(all.getName() + " - " + all.getpageCount());

        }
        book1 = books[0];
        books[0] = books[3];
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            Book all = books[i];
            System.out.println(all.getName() + " - " + all.getpageCount());
        }

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getpageCount());
                break;
            }
        }
    }
}

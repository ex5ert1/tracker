package ru;

public class Format {

    public static void getGreeting(String name) {
        System.out.printf("Привет! Я %s%nп", name);
    }

    public static void main(String[] args) {
        getGreeting("Елена");
    }

}

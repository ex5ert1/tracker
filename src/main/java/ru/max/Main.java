package ru.max;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Dog dog = new Dog();
        dog.method(7);
        cat();
    }

    public static void cat() throws IOException{
        throw new IOException();
    }
}

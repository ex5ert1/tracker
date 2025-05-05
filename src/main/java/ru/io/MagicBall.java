package ru.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = scanner.nextLine();
        int answer = new Random().nextInt(4);
        String result;
        if (answer == 0) {
            result = "Да";
        } else if (answer == 1) {
            result = "Нет";
        } else {
            result = "Может быть";
        }
        System.out.println("Оракул говорит: " + result);
        scanner.close();
    }
}

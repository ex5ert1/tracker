package ru.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            boolean validInput = false;
            while (!validInput) {
                if (input.hasNextInt()) {
                    matches = input.nextInt();
                    if (matches >= 1 && matches <= 3 && matches <= count) {
                        validInput = true;
                    } else {
                        System.out.println("Неверный ввод. Введите число от 1 до 3, не превышающее количество оставшихся спичек.");
                    }
                } else {
                    System.out.println("Неверный ввод. Введите число.");
                    input.nextLine();
                }
            }

            count -= matches;
            System.out.println("Осталось спичек: " + count);

            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}



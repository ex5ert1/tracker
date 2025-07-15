package ru.tracker.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidateInput extends ConsoleInput {
    private final BufferedReader reader;

    public ValidateInput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public int askInt(String question) {
        while (true) {
            try {
                System.out.print(question);
                String input = reader.readLine();
                if (input == null || input.isEmpty()) {
                    throw new NumberFormatException();
                }
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные числовые данные");
            } catch (IOException e) {
                System.out.println("Произошла ошибка при чтении ввода");
            }
        }
    }

    @Override
    public String askStr(String question) {
        try {
            System.out.print(question);
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении ввода");
            return "";
        }
    }
}


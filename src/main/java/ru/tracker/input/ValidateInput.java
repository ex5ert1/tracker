package ru.tracker.input;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        while (true) {
            try {
                return super.askInt(question);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные числовые данные");
            }
        }
    }

    @Override
    public String askStr(String question) {
        try {
            return super.askStr(question);
        } catch (Exception e) {
            System.out.println("Произошла ошибка при чтении ввода");
            return "";
        }
    }
}


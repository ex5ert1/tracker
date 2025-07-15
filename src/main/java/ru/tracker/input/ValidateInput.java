package ru.tracker.input;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        while (true) {
            try {
                String input = super.askStr(question);
                if (input == null || input.isEmpty()) {
                    throw new NumberFormatException();
                }
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные числовые данные");
            }
        }
    }

    @Override
    public String askStr(String question) {
        try {
            String input = super.askStr(question);
            if (input == null || input.isEmpty()) {
                return "";
            }
            return input.trim();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при чтении ввода");
            return "";
        }
    }
}


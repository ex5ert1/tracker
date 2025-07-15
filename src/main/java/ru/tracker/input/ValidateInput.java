package ru.tracker.input;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        while (true) {
            try {
                return super.askInt(question);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные числовые данные");
            } catch (Exception e) {
                System.out.println("Произошла ошибка при чтении ввода");
            }
        }
    }

    @Override
    public String askStr(String question) {
        try {
            String input = super.askStr(question).trim();
            return input.isEmpty() ? "" : input;
        } catch (Exception e) {
            System.out.println("Произошла ошибка при чтении ввода");
            return "";
        }
    }
}


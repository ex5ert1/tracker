package ru.tracker;

public class ExitAction implements UserAction {
    public ExitAction(Output output) {
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Завершение программы ===");
        return false;
    }
}

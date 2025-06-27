package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.output.Output;
import ru.tracker.core.Tracker;

public class Exit implements UserAction {
    private final Output output;

    public Exit(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Завершение программы ===");
        return false;
    }
}

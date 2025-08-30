package ru.tracker.action;

import ru.tracker.core.Tracker;
import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.output.Output;
import java.util.List;

public class FindAll implements UserAction {
    private final Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Вывести все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод всех заявок ===");
        List<Item> items = tracker.findAll();

        if (items.isEmpty()) {
            output.println("Хранилище еще не содержит заявок");
        } else {
            for (Item item : items) {
                output.println(item);
            }
        }
        return true;
    }
}

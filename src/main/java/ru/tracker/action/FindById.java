package ru.tracker.action;

import ru.tracker.core.Tracker;
import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.output.Output;

public class FindById implements UserAction {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Поиск заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Заявки с таким id не существует");
        }
        return true;
    }
}

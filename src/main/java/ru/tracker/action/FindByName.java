package ru.tracker.action;

import ru.tracker.core.Tracker;
import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.output.Output;

public class FindByName implements UserAction {
    private final Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Поиск заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Ведите имя заявки: ");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems.length > 0) {
            output.println("Найдены заявки:");
            for (Item item : foundItems) {
                output.println(item);
            }
        } else {
            output.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

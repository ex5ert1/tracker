package ru.tracker;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
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

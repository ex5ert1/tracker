package ru.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Поиск заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Ведите имя заявки: ");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems.length > 0) {
            System.out.println("Найдены заявки:");
            for (Item item : foundItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

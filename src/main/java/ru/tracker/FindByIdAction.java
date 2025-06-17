package ru.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Поиск заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявки с таким id не существует");
        }
        return true;
    }
}

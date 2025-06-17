package ru.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Ошибка! Заявка с таким ID не найдена.");
        }
        return true;
    }
}

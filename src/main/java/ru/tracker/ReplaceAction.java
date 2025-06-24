package ru.tracker;

public class ReplaceAction implements UserAction {
    public ReplaceAction(Output output) {
    }

    @Override
    public String name() {
        return "Редактировать заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите ID редактируемой заявки: ");
        String newName = input.askStr("Введите новое имя заявки: ");
        Item updatedItem = new Item(newName);
        if (tracker.replace(id, updatedItem)) {
            System.out.println("Заявка успешно обновлена: " + updatedItem);
        } else {
            System.out.println("Ошибка! Заявка с ID " + id + " не найдена.");
        }
        return true;
    }
}

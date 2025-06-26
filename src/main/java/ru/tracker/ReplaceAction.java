package ru.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
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
            output.println("Заявка успешно обновлена.");
        } else {
            output.println("Ошибка! Заявка с ID " + id + " не найдена.");
        }
        return true;
    }
}

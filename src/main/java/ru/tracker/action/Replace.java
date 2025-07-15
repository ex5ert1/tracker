package ru.tracker.action;

import ru.tracker.core.Tracker;
import ru.tracker.input.Input;
import ru.tracker.model.Item;
import ru.tracker.output.Output;

public class Replace implements UserAction {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Редактировать заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        try {
            int id = input.askInt("Введите ID редактируемой заявки: ");
            String newName = input.askStr("Введите новое имя заявки: ");
            if (newName == null || newName.isEmpty()) {
                throw new IllegalArgumentException("Название заявки не может быть пустым");
            }
            Item updatedItem = new Item(newName);
            if (tracker.replace(id, updatedItem)) {
                output.println("Заявка успешно обновлена.");
            } else {
                output.println("Ошибка! Заявка с ID " + id + " не найдена.");
            }
        } catch (NumberFormatException e) {
            output.println("Ошибка: введите корректное числовое значение ID");
        } catch (IllegalArgumentException e) {
            output.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            output.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
        return true;
    }
}


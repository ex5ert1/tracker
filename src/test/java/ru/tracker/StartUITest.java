package ru.tracker;

import org.junit.jupiter.api.Test;
import ru.tracker.action.*;
import ru.tracker.core.Tracker;
import ru.tracker.input.Input;
import ru.tracker.input.MockInput;
import ru.tracker.model.Item;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;
import ru.tracker.ui.StartUI;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add("Item name");
        answers.add("1");

        Input input = new MockInput(answers, output);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Create(output));
        actions.add(new Exit(output));

        new StartUI(output).init(input, tracker, actions);
        List<Item> allItems = tracker.findAll();
        assertThat(allItems.get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item1 = new Item("first item");
        tracker.add(item1);
        Item item2 = new Item("second item");
        tracker.add(item2);

        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(item2.getId()));
        answers.add("new item");
        answers.add("1");

        Input input = new MockInput(answers, output);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Replace(output));
        actions.add(new Exit(output));

        new StartUI(output).init(input, tracker, actions);
        Item updatedItem = tracker.findById(item2.getId());
        assertThat(updatedItem.getName()).isEqualTo("new item");
        Item firstItem = tracker.findById(item1.getId());
        assertThat(firstItem).isNotNull();
        assertThat(firstItem.getName()).isEqualTo("first item");
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item1 = new Item("first item");
        tracker.add(item1);
        Item item2 = new Item("second item");
        tracker.add(item2);

        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(item1.getId()));
        answers.add("1");

        Input input = new MockInput(answers, output);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Delete(output));
        actions.add(new Exit(output));

        new StartUI(output).init(input, tracker, actions);
        Item deletedItem = tracker.findById(item1.getId());
        assertThat(deletedItem).isNull();
        assertThat(tracker.findById(item2.getId())).isNotNull();
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        Input input = new MockInput(answers, output);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Exit(output));

        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "Выбрать: " + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        ArrayList<String> answers = new ArrayList<>();
        answers.add("0");
        answers.add(String.valueOf(one.getId()));
        answers.add(replaceName);
        answers.add("1");
        Input input = new MockInput(answers, output);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Replace(output));
        actions.add(new Exit(output));

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Редактировать заявку" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Введите ID редактируемой заявки: " + ln
                        + "Введите новое имя заявки: " + ln
                        + "Заявка успешно обновлена." + ln
                        + "Меню:" + ln
                        + "0. Редактировать заявку" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}

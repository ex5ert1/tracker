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
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        List<String> answers = List.of("0", "Item name", "1");

        Input input = new MockInput(answers, output);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new Create(output),
                new Exit(output)
        );

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

        List<String> answers = List.of("0", String.valueOf(item2.getId()), "new item", "1");

        Input input = new MockInput(answers, output);
        List<UserAction> actions = List.of(
                new Replace(output),
                new Exit(output)
        );

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

        List<String> answers = List.of("0", String.valueOf(item1.getId()), "1");

        Input input = new MockInput(answers, output);
        List<UserAction> actions = List.of(
                new Delete(output),
                new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);
        Item deletedItem = tracker.findById(item1.getId());
        assertThat(deletedItem).isNull();
        assertThat(tracker.findById(item2.getId())).isNotNull();
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        List<String> answers = List.of("0");
        Input input = new MockInput(answers, output);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new Exit(output)
        );

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
        List<String> answers = List.of("0", String.valueOf(one.getId()), replaceName, "1");
        Input input = new MockInput(answers, output);
        List<UserAction> actions = List.of(
                new Replace(output),
                new Exit(output)
        );

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

    @Test
    void whenFindAllItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Заявка 1"));
        Item item2 = tracker.add(new Item("Заявка 2"));

        List<String> answers = List.of("0", "1");

        Input input = new MockInput(answers, output);

        List<UserAction> actions = List.of(
                new FindAll(output),
                new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывести все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Вывод всех заявок ===" + ln
                        + item1 + ln
                        + item2 + ln
                        + "Меню:" + ln
                        + "0. Вывести все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllINoItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();

        List<String> answers = List.of("0", "1");

        Input input = new MockInput(answers, output);

        List<UserAction> actions = List.of(
                new FindAll(output),
                new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывести все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Вывести все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenNoItemsFoundTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        List<String> answers = List.of("0", "1");

        Input input = new MockInput(answers, output);

        List<UserAction> actions = List.of(
                new FindAll(output),
                new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывести все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Вывести все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Заявка 1"));
        Item item2 = tracker.add(new Item("Заявка 2"));
        List<String> answers = List.of("0", "Заявка 1", "1");

        Input input = new MockInput(answers, output);

        List<UserAction> actions = List.of(
                new FindByName(output),
                new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Поиск заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Введите имя заявки: " + ln
                        + "Найдены заявки:" + ln
                        + item1 + ln
                        + "Меню:" + ln
                        + "0. Поиск заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        List<String> answers = List.of("9", "1");

        Input input = new MockInput(answers, output);

        List<UserAction> actions = List.of(
                new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}

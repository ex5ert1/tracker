package ru.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"},
                output
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item1 = new Item("first item");
        tracker.add(item1);
        Item item2 = new Item("second item");
        tracker.add(item2);

        Input input = new MockInput(
                new String[] { "0", String.valueOf(item2.getId()), "new item", "1" },
                output
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
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
        Input input = new MockInput(
                new String[] {
                        "0", String.valueOf(item1.getId()), "1"
                },
                output
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item deletedItem = tracker.findById(item1.getId());
        assertThat(deletedItem).isNull();
        assertThat(tracker.findById(item2.getId())).isNotNull();
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0"},
                output
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
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
        Input input = new MockInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"},
                output
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(output),
                new ExitAction(output)
        };
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
        Input input = new MockInput(
                new String[] {"0", "1"},
                output
        );
        UserAction[] actions = new UserAction[] {
                new FindAllAction(output),
                new ExitAction(output)
        };
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
    void whenNoItemsFoundTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                new String[] {"0", "1"},
                output
        );
        UserAction[] actions = new UserAction[] {
                new FindAllAction(output),
                new ExitAction(output)
        };
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
    void whenFindByIdItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Заявка 1"));
        Item item2 = tracker.add(new Item("Заявка 2"));
        Input input = new MockInput(
                new String[] {"0", String.valueOf(item1.getId()), "1"},
                output
        );
        UserAction[] actions = new UserAction[] {
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Поиск заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Введите id: " + ln
                        + item1 + ln
                        + "Меню:" + ln
                        + "0. Поиск заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenNoFindByIdItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                new String[] {"0", "1", "1"},
                output
        );
        UserAction[] actions = new UserAction[] {
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Поиск заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Введите id: " + ln
                        + "Заявки с таким id не существует" + ln  // Добавляем ожидаемый вывод при отсутствии заявки
                        + "Меню:" + ln
                        + "0. Поиск заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenNoItemsFoundByNameTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                new String[] {"0", "Неверное имя", "1"},
                output
        );
        UserAction[] actions = new UserAction[] {
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Поиск заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Ведите имя заявки: " + ln
                        + "Заявки с таким именем не найдены" + ln // Ожидаемое сообщение об ошибке
                        + "Меню:" + ln
                        + "0. Поиск заявки по имени" + ln
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
        Input input = new MockInput(
                new String[] {"0", "Заявка 1", "1"},
                output
        );
        UserAction[] actions = new UserAction[] {
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Поиск заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "Ведите имя заявки: " + ln
                        + "Найдены заявки:" + ln
                        + item1 + ln
                        + "Меню:" + ln
                        + "0. Поиск заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}

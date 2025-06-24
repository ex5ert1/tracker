package ru.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(new String[]{"Item name"});
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        CreateAction createAction = new CreateAction(output);
        boolean result = createAction.execute(input, tracker);
        assertThat(result).isTrue();
        assertThat(tracker.findAll()).hasSize(1);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("first item");
        tracker.add(item1);
        Item item2 = new Item("second item");
        tracker.add(item2);
        Input input = new MockInput(
                new String[] {
                        String.valueOf(item2.getId()), "new item"
                }
        );
        Output output = new MockOutput();
        ReplaceAction replaceAction = new ReplaceAction(output);
        boolean result = replaceAction.execute(input, tracker);
        assertThat(result).isTrue();
        Item updatedItem = tracker.findById(item2.getId());
        assertThat(updatedItem).isNotNull();
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
                }
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item deletedItem = tracker.findById(item1.getId());
        assertThat(deletedItem).isNull();
        assertThat(tracker.findById(item2.getId())).isNotNull();
        assertThat(output.toString()).contains("Заявка успешно удалена.");
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }
}

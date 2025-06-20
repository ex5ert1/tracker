package ru.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("old item");
        tracker.add(item);

        Input input = new MockInput(
                new String[] { "0", String.valueOf(item.getId()), "new item", "1" }
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        Item updatedItem = tracker.findById(item.getId());
        assertThat(updatedItem.getName()).isEqualTo("new item");
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("item to delete");
        tracker.add(item);
        Input input = new MockInput(
                new String[] { "0", String.valueOf(item.getId()), "1" }
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        Item deletedItem = tracker.findById(item.getId());
        assertThat(deletedItem).isNull();
    }
}
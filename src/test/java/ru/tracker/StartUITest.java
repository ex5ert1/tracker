package ru.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void createItem() {
        String[] answers = {"Первая Тестовая"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Первая Тестовая");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Первая заявка");
        Item item2 = new Item("Вторая заявка");
        tracker.add(item1);
        tracker.add(item2);

        String[] answers = {
                String.valueOf(item2.getId()),
                "edited item"
        };
        StartUI.replaceItem(new MockInput(answers), tracker);
        Item edited = tracker.findById(item2.getId());
        assertThat(edited.getName()).isEqualTo("edited item");
    }

    @Test
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Первая заявка");
        Item item2 = new Item("Вторая заявка");
        tracker.add(item1);
        tracker.add(item2);

        String[] answers = {
                String.valueOf(item2.getId())
        };
        StartUI.deleteItem(new MockInput(answers), tracker);
        Item deleted = tracker.findById(item2.getId());
        assertThat(deleted).isNull();
    }
}
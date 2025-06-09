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
}
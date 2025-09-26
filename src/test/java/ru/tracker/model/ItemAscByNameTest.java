package ru.tracker.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ItemAscByNameTest {
    @Test
    void testSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3, "Груша"));
        items.add(new Item(1, "Яблоко"));
        items.add(new Item(2, "Апельсин"));
        items.add(new Item(4, "Банан"));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(2, "Апельсин"));
        expected.add(new Item(4, "Банан"));
        expected.add(new Item(3, "Груша"));
        expected.add(new Item(1, "Яблоко"));
        items.sort(new ItemAscByName());

        assertEquals(expected.size(), items.size());
        for (int i = 0; i < items.size(); i++) {
            Item actualItem = items.get(i);
            Item expectedItem = expected.get(i);
            assertEquals(expectedItem.getId(), actualItem.getId());
            assertEquals(expectedItem.getName(), actualItem.getName());
        }
    }
}
package ru.tracker.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class ItemAscByNameTest {
    @Test
    void testSortAscByName() {
        LocalDateTime fixedTime = LocalDateTime.now();
        List<Item> items = new ArrayList<>();
        items.add(new Item(3, "Груша", fixedTime));
        items.add(new Item(1, "Яблоко", fixedTime));
        items.add(new Item(2, "Апельсин", fixedTime));
        items.add(new Item(4, "Банан", fixedTime));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(2, "Апельсин", fixedTime));
        expected.add(new Item(4, "Банан", fixedTime));
        expected.add(new Item(3, "Груша", fixedTime));
        expected.add(new Item(1, "Яблоко", fixedTime));
        items.sort(new ItemAscByName());

        assertEquals(expected.size(), items.size());
        for (int i = 0; i < items.size(); i++) {
            Item actual = items.get(i);
            Item expectedItem = expected.get(i);

            assertEquals(expectedItem.getId(), actual.getId());
            assertEquals(expectedItem.getName(), actual.getName());
            assertEquals(expectedItem.getCreated(), actual.getCreated());
        }
    }
}
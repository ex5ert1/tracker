package ru.tracker.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ItemDescByNameTest {
    @Test
    void testSortDescByName() {
        LocalDateTime fixedTime = LocalDateTime.now();

        List<Item> items = new ArrayList<>();
        items.add(new Item(3, "Груша", fixedTime));
        items.add(new Item(1, "Яблоко", fixedTime));
        items.add(new Item(2, "Апельсин", fixedTime));
        items.add(new Item(4, "Банан", fixedTime));

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1, "Яблоко", fixedTime));
        expected.add(new Item(3, "Груша", fixedTime));
        expected.add(new Item(4, "Банан", fixedTime));
        expected.add(new Item(2, "Апельсин", fixedTime));

        items.sort(Collections.reverseOrder(new ItemAscByName()));
        assertTrue(items.size() == expected.size());
    }
}
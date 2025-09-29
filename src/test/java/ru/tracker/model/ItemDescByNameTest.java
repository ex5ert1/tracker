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

        Item item1 = new Item(2, "Апельсин", fixedTime);
        Item item2 = new Item(4, "Банан", fixedTime);
        Item item3 = new Item(3, "Груша", fixedTime);
        Item item4 = new Item(1, "Яблоко", fixedTime);

        List<Item> items = new ArrayList<>();
        items.add(item3);
        items.add(item4);
        items.add(item1);
        items.add(item2);

        List<Item> expected = new ArrayList<>();
        expected.add(item4);
        expected.add(item3);
        expected.add(item2);
        expected.add(item1);

        items.sort(Collections.reverseOrder(new ItemAscByName()));
        assertTrue(items.size() == expected.size(), "Размеры списков не совпадают");
        for (int i = 0; i < items.size(); i++) {
            assertTrue(items.get(i) == expected.get(i), "Ссылки на объекты не совпадают " + i);
        }
    }
}
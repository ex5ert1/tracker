package ru.tracker;

import ru.tracker.Item;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("Не знаю что выводить но допустим так");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedDate = item.getCreated().format(formatter);

        System.out.println("Создано: " + formattedDate);
    }
}

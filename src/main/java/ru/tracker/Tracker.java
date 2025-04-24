package ru.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                result[index++] = items[i];
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        int found = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                found++;
            }
        }

        Item[] result = new Item[found];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[index++] = items[i];
            }
        }
        return result;
    }
}
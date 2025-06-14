package ru.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Введите номер раздела от 0 до 6: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Показать заявки по имени ===");
        String name = input.askStr("Ведите имя заявки: ");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems.length > 0) {
            System.out.println("Найдены заявки:");
            for (Item item : foundItems) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Показать заявку по id ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявки с таким id не существует");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Ошибка! Заявка с таким ID не найдена.");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        int id = input.askInt("Введите ID редактируемой заявки: ");
        String newName = input.askStr("Введите новое имя заявки: ");
        Item updatedItem = new Item(newName);
        if (tracker.replace(id, updatedItem)) {
            System.out.println("Заявка успешно обновлена: " + updatedItem);
        } else {
            System.out.println("Ошибка! Заявка с ID " + id + " не найдена.");
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Создание новой заявки ===");
        String name = input.askStr("Ведите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Хранилище еще не содержит заявок");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени", "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

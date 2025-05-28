package ru.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Создание новой заявки ===");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length == 0) {
                    System.out.println("Хранилище еще не содержит заявок");
                } else {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Редактирование заявки ===");
                System.out.print("Введите ID редактируемой заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите новое имя заявки: ");
                String newName = scanner.nextLine();
                Item updatedItem = new Item(newName);
                if (tracker.replace(id, updatedItem)) {
                    System.out.println("Заявка успешно обновлена: " + updatedItem);
                } else {
                    System.out.println("Ошибка! Заявка с ID " + id + " не найдена.");
                }
            } else if (select == 3) {
                System.out.println("=== Удаление заявки ===");
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    tracker.delete(id);
                    System.out.println("Заявка успешно удалена.");
                } else {
                    System.out.println("Ошибка! Заявка с таким ID не найдена.");
                }
            } else if (select == 4) {
                System.out.println("=== Показать заявку по id ===");
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявки с таким id не существует");
                }
            } else if (select == 5) {
                System.out.println("=== Показать заявки по имени ===");
                System.out.print("Введите имя заявки ");
                String name = scanner.nextLine();
                Item[] foundItems = tracker.findByName(name);
                if (foundItems.length > 0) {
                    System.out.println("Найдены заявки:");
                    for (Item item : foundItems) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

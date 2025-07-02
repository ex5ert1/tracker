package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (value == null || key == null) {
            throw new NullPointerException("Параметры не могут быть null");
        }
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Элемент " + key + " не найден в массиве");
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "cherry", "date"};

        try {
            System.out.println("Индекс банана: " + indexOf(array, "banana"));
            System.out.println("Индекс груши: " + indexOf(array, "pear"));
        } catch (ElementNotFoundException | NullPointerException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
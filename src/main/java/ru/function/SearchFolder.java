package ru.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    /**
     * Универсальный метод фильтрации списка папок по заданному условию (предикату).
     *
     * @param list список папок для фильтрации
     * @param predicate условие фильтрации (реализует интерфейс Predicate<Folder>)
     * @return новый список, содержащий только папки, удовлетворяющие предикату
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (predicate.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
}

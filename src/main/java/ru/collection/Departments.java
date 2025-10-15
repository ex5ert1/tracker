package ru.collection;

import java.util.*;

public class Departments {

    /**
     * Заполняет пропуски в иерархии подразделений, добавляя все промежуточные уровни.
     * Для каждой входной строки разбивает её на части по символу '/' и последовательно
     * формирует все возможные пути от верхнего уровня к текущему подразделению.
     * Использует LinkedHashSet для автоматического устранения дубликатов с сохранением порядка добавления.
     *
     * @param departments исходный список кодов подразделений, возможно с пропущенными уровнями иерархии
     * @return список кодов подразделений с восстановленными промежуточными уровнями
     */
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();

        for (String department : departments) {
            String[] parts = department.split("/");
            StringBuilder path = new StringBuilder();

            for (String part : parts) {
                if (path.length() > 0) {
                    path.append("/");
                }
                path.append(part);
                temp.add(path.toString());
            }
        }

        return new ArrayList<>(temp);
    }

    /**
     * Сортирует список подразделений в порядке возрастания (лексикографически).
     * Использует стандартный компаратор Comparator.naturalOrder() для сортировки строк.
     * Не модифицирует иерархическую структуру — просто упорядочивает существующие элементы.
     *
     * @param departments список кодов подразделений для сортировки
     */
    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    /**
     * Сортирует список подразделений в порядке убывания с учётом иерархии.
     * Использует специальный компаратор DepartmentsDescComparator, который:
     * - сначала сравнивает первые уровни в обратном порядке;
     * - при равенстве первых уровней отдаёт приоритет более коротким путям;
     * - при равной длине выполняет лексикографическое сравнение.
     *
     * @param departments список кодов подразделений для сортировки
     */
    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");
        int firstLevelDiff = rightParts[0].compareTo(leftParts[0]);
        return firstLevelDiff != 0 ? firstLevelDiff : left.compareTo(right);
    }
}
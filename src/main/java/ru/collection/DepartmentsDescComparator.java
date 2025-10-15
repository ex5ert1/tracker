package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");
        int firstLevel = rightParts[0].compareTo(leftParts[0]);
        if (firstLevel != 0) {
            return firstLevel;
        }
        return left.compareTo(right);
    }
}
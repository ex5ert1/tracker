package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            int charCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (charCompare != 0) {
                return charCompare;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}

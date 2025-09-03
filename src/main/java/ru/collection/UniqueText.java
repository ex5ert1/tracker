package ru.collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] originWords = originText.split(" ");
        String[] duplicateWords = duplicateText.split(" ");
        if (originWords.length != duplicateWords.length) {
            return false;
        }

        Set<String> originSet = new HashSet<>();
        for (String word : originWords) {
            originSet.add(word);
        }

        for (String word : duplicateWords) {
            if (!originSet.contains(word)) {
                return false;
            }
        }
        return result;
    }
}

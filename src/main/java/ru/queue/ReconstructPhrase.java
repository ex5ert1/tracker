package ru.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        String result = "";
        int size = evenElements.size();
        Character currentChar = null;

        for (int i = 0; i < size; i++) {
            currentChar = evenElements.poll();
            if (i % 2 == 0) {
                result += currentChar;
            }
        }
        return result;
    }

    private String getDescendingElements() {
        String result = "";
        int size = descendingElements.size();
        Character currentChar = null;

        for (int i = 0; i < size; i++) {
            currentChar = descendingElements.pollLast();
            result += currentChar;
        }
        return result;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
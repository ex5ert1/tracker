package ru.tracker.input;

import ru.tracker.output.Output;

public class MockInput implements Input {
    private String[] answers;
    private int position = 0;
    private Output output;

    public MockInput(String[] answers, Output output) {
        this.answers = answers;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        output.println(question);
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}

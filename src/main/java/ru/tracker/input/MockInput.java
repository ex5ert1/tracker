package ru.tracker.input;

import ru.tracker.output.Output;

import java.util.ArrayList;
import java.util.List;

public class MockInput implements Input {
    private List<String> answers;
    private int position = 0;
    private Output output;

    public MockInput(List<String> answers, Output output) {
        this.answers = answers;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        output.println(question);
        return answers.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}

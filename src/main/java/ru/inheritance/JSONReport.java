package ru.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        String lineSeparator = System.lineSeparator();

        return "{" + lineSeparator +
                "\t\"name\" : \"" + name + "\"," + lineSeparator +
                "\t\"body\" : \"" + body + "\"" + lineSeparator +
                "}";
    }
}

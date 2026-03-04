package ru.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .filter(student -> student.getScore() >= bound)
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .collect(Collectors.toList());
    }
}
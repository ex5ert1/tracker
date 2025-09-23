package ru.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(p -> p.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        return pupils.stream()
                .map(p -> new Label(
                        p.name(),
                        p.subjects().stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0D)
                ))
                .collect(Collectors.toList());
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.averagingInt(Subject::score)
                ))
                .entrySet()
                .stream()
                .map(e -> new Label(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return pupils.stream()
                .map(p -> new Label(
                        p.name(),
                        p.subjects().stream()
                                .mapToInt(Subject::score)
                                .sum()
                ))
                .max(Comparator.comparingDouble(Label::score))
                .orElse(null);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return pupils.stream()
                .flatMap(p -> p.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.summingInt(Subject::score)
                ))
                .entrySet()
                .stream()
                .map(e -> new Label(e.getKey(), e.getValue()))
                .max(Comparator.comparingDouble(Label::score))
                .orElse(null);
    }
}
package ru.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, -2, 0, 3, 7, -1, 10, 0, -8, 4);
        List<Integer> positive = numbers.stream()
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}

package ru.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    /**
     * Вычисляет значения функции на диапазоне [start, end) с шагом 1.
     *
     * @param start начало диапазона (включительно)
     * @param end конец диапазона (исключительно)
     * @param function функция, которую нужно вычислить (принимает Double, возвращает Double)
     * @return список вычисленных значений функции
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            Double value = function.apply((double) i);
            result.add(value);
        }
        return result;
    }
}


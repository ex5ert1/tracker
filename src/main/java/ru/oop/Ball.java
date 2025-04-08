package ru.oop;

public class Ball {
    public void tryRun(boolean isCondition) {
        if (isCondition == true) {
            System.out.println("Колобок съеден!");
        } else {
            System.out.println("Колобок сбежал!");
        }
    }
}

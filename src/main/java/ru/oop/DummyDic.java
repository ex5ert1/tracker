package ru.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        DummyDic name = new DummyDic();
        String result = name.engToRus("жава");
        System.out.println("Неизвестное слово. " + result);
    }
}

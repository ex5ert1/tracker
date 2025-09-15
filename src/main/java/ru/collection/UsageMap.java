package ru.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> human = new HashMap<>();
        human.put("qwerty@yandex.ru", "Ivan Ivanov");
        human.put("qwerty123@yandex.ru", "Egor Ivanov");
        for (String key : human.keySet()) {
            System.out.println(key + " : " + human.get(key));
        }
    }
}

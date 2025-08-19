package ru.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList names = new ArrayList();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (Object name : names) {
            System.out.println(name);
        }
    }
}

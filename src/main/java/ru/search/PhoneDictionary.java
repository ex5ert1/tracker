package ru.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Ключ поиска не может быть пустым");
        }

        ArrayList<Person> result = new ArrayList<>();
        String searchKey = key.toLowerCase();
        for (Person person : persons) {
            if ((person.getName() != null && person.getName().toLowerCase().contains(searchKey)) ||
                    (person.getSurname() != null && person.getSurname().toLowerCase().contains(searchKey)) ||
                    (person.getPhone() != null && person.getPhone().toLowerCase().contains(searchKey)) ||
                    (person.getAddress() != null && person.getAddress().toLowerCase().contains(searchKey))) {
                result.add(person);
            }
        }
        return result;
    }
}


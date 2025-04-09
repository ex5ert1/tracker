package ru.oop;

public class Tamagotchi {
    private int weight = 100;

    public void feed() {
        weight += 10;
    }

    public String info() {
        return "weight: " + weight;
    }

    public static void feedPet(Tamagotchi petCopy) {
        petCopy.feed();
    }

    public static void main(String[] args) {
        Tamagotchi pet = new Tamagotchi();
        Tamagotchi pet2 = pet;
        System.out.println("pet: " + pet.info());
        System.out.println("pet2: " + pet2.info());
        pet2.feed();
        System.out.println("pet: " + pet.info());
        System.out.println("pet2: " + pet2.info());
    }
}


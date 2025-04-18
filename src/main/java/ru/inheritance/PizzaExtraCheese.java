package ru.inheritance;

public class PizzaExtraCheese extends Pizza {
    @Override
    public String name() {
        return super.name() + " with extra cheese";
    }
}

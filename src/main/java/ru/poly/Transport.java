package ru.poly;

public interface Transport {
    void drive();

    void setPassengers(int amount);

    double refuel(double fuelAmount);
}
package ru.poly;

public class Bus implements Transport {
    private double currentFuel = 0.0;

    @Override
    public void drive() {
        if (currentFuel > 0) {
            System.out.println("Автобус едет");
            currentFuel -= 0.1;
        } else {
            System.out.println("Автобус не может ехать, пустой бак!");
        }
    }

    @Override
    public void setPassengers(int amount) {
        if (amount >= 0) {
            System.out.println("В автобусе " + amount + " пассажиров");
        } else {
            System.out.println("Неверное количество пассажиров!");
        }
    }

    @Override
    public double refuel(double fuelAmount) {
        double maxFuelCapacity = 200.0;
        double remainingSpace = maxFuelCapacity - currentFuel;
        double fueled = Math.min(fuelAmount, remainingSpace);
        currentFuel += fueled;
        double pricePerLiter = 50.0;
        double cost = fueled * pricePerLiter;
        System.out.println("Заправлено " + fueled + " литров на сумму" + cost + " рублей");
        return cost;
    }
}

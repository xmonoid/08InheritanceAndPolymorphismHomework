package com.tsystems.autotestuni.basic;

public class Car extends Vehicle {

    private final short maxNumberOfPassengers;

    public Car(short maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    @Override
    public byte getNumberOfWheels() {
        return 4;
    }

    @Override
    public short getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }
}

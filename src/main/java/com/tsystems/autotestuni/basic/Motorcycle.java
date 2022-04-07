package com.tsystems.autotestuni.basic;

public class Motorcycle extends Vehicle {

    @Override
    public byte getNumberOfWheels() {
        return 2;
    }

    @Override
    public short getMaxNumberOfPassengers() {
        return 1;
    }
}

package com.tsystems.autotestuni.basic;

public class Bus extends Vehicle {

    private final byte numberOfWheels;
    private final short maxNumberOfPassengers;

    public Bus(byte numberOfWheels, short maxNumberOfPassengers) {
        this.numberOfWheels = numberOfWheels;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    @Override
    public byte getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public short getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }
}

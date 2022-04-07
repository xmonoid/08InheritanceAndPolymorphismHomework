package com.tsystems.autotestuni.basic;

public abstract class Vehicle {

    private boolean engineStarted;

    public final void startEngine() {
        engineStarted = true;
    }

    public final void stopEngine() {
        engineStarted = false;
    }

    public final boolean isEngineStarted() {
        return engineStarted;
    }

    public abstract byte getNumberOfWheels();

    public abstract short getMaxNumberOfPassengers();
}

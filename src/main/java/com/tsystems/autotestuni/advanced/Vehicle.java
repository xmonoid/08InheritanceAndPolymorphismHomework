package com.tsystems.autotestuni.advanced;

import java.util.Objects;

/**
 * Read this article
 * https://www.baeldung.com/java-equals-hashcode-contracts
 *
 * and implement methods {@code equals()} and {@code hashCode()} to pass all tests.
 *
 * Use only {@code vin} and {@code numberOfWheels} fields and do not use {@code license}.
 */
public abstract class Vehicle {

    protected transient String license; // Is not participated in comparisons!

    protected final String vin;
    protected final short numberOfWheels;

    public Vehicle(String vin, short numberOfWheels) {
        this.vin = vin;
        this.numberOfWheels = numberOfWheels;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return numberOfWheels == vehicle.numberOfWheels && vin.equals(vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(license, vin, numberOfWheels);
    }
}

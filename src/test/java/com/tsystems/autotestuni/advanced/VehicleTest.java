package com.tsystems.autotestuni.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testEquals() {
        final var car1 = new Car("WDD2053661F935811", (short) 4);
        final var car2 = new Car("WDD2053661F935811", (short) 4);
        final var bus1 = new Bus("W9FZ55Z98F36FB52F", (short) 10);

        assertFalse(car1.equals(null), "No object can be equal to null");
        assertTrue(car1.equals(car1), "Every object should be equal to itself");
        assertFalse(car1.equals(bus1), "Objects of different classes cannot be equal");

        car1.setLicense("12345");
        car2.setLicense("54321");
        assertTrue(car1.equals(car2), "Objects of the same type contain the same info should be equal");

        assertFalse(bus1.equals(car1), "Inequality should be symmetric");
        assertTrue(car2.equals(car1), "Equality should be symmetric");
    }

    @Test
    void testHashCode() {
        final var car1 = new Car("WDD2053661F935811", (short) 4);
        final var car2 = new Car("WDD2053661F935811", (short) 4);
        final var bus1 = new Bus("W9FZ55Z98F36FB52F", (short) 10);

        final int hashCar1 = car1.hashCode();
        final int hashCar2 = car2.hashCode();
        final int hashBus1 = bus1.hashCode();

        assertTrue(car1.equals(car2), "Objects of the same type contain the same info should be equal");
        assertTrue(hashCar1 == hashCar2, "Equal object should have the same hash code");

        assertFalse(car1.equals(bus1), "Objects of different classes cannot be equal");

        // May be false in extremely rare cases
        assertFalse(hashCar1 == hashBus1,
                "Unequal objects IN THE MOST PROBABLE CASES should have different hash codes");
    }
}
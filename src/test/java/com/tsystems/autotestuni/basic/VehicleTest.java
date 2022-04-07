package com.tsystems.autotestuni.basic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Create the following class hierarchy.
 *
 * Abstract {@code Vehicle} class with a {@code private boolean engineStarted} field and three final methods:
 *
 *  {@code void startEngine()} and {@code void stopEngine()},
 *      which set {@code engineStarted} field to {@code true} and {@code false}, respectively;
 *  {@code boolean isEngineStarted()}, which returns the current value of the field {@code engineStarted}.
 *
 * Two abstract methods:
 *  {@code byte getNumberOfWheels()}, returning the number of wheels.
 *  {@code short getMaxNumberOfPassengers()}, returning the maximum number of passengers.
 *
 *
 * Three child classes: {@code Motorcycle}, {@code Car}, and {@code Bus}.
 *
 * In {@code Motorcycle}, the number of wheels is always 2, the maximum number of passengers is 1.
 * In a {@code Car}, the number of wheels is always 4, but the maximum number of passengers can be from 2 to 4,
 * this is set in the constructor and cannot be changed in the future.
 * In {@code Bus}, both the number of wheels and the maximum number of passengers are set in the constructor
 * and both cannot be changed in the future.
 */
class VehicleTest {

    @Test
    void testVehicle() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Vehicle"),
                "Class Vehicle does not exist");
        Class<?> vehicleClass = Class.forName("com.tsystems.autotestuni.basic.Vehicle");
        Field engineStarted = vehicleClass.getDeclaredField("engineStarted");
        assertEquals(Boolean.TYPE, engineStarted.getType(),
                "The field engineStarted should be boolean");
        assertTrue(Modifier.isPrivate(engineStarted.getModifiers()),
                "The field engineStarted should be private");

        Method startEngine = vehicleClass.getDeclaredMethod("startEngine");
        assertEquals(Void.TYPE, startEngine.getReturnType(),
                "The method startEngine should not return any type");
        assertEquals(0, startEngine.getParameterCount(),
                "The method startEngine should have no parameters");
        assertTrue(Modifier.isPublic(startEngine.getModifiers()),
                "The method startEngine should be public");
        assertTrue(Modifier.isFinal(startEngine.getModifiers()),
                "The method startEngine should be final");

        Method stopEngine = vehicleClass.getDeclaredMethod("stopEngine");
        assertEquals(Void.TYPE, stopEngine.getReturnType(),
                "The method stopEngine should not return any type");
        assertEquals(0, stopEngine.getParameterCount(),
                "The method stopEngine should have no parameters");
        assertTrue(Modifier.isPublic(stopEngine.getModifiers()),
                "The method stopEngine should be public");
        assertTrue(Modifier.isFinal(stopEngine.getModifiers()),
                "The method stopEngine should be final");

        Method isEngineStarted = vehicleClass.getDeclaredMethod("isEngineStarted");
        assertEquals(Boolean.TYPE, isEngineStarted.getReturnType(),
                "The method isEngineStarted should return boolean type");
        assertEquals(0, isEngineStarted.getParameterCount(),
                "The method isEngineStarted should have no parameters");
        assertTrue(Modifier.isPublic(isEngineStarted.getModifiers()),
                "The method isEngineStarted should be public");
        assertTrue(Modifier.isFinal(isEngineStarted.getModifiers()),
                "The method isEngineStarted should be final");

        Method getNumberOfWheels = vehicleClass.getDeclaredMethod("getNumberOfWheels");
        assertEquals(Byte.TYPE, getNumberOfWheels.getReturnType(),
                "The method getNumberOfWheels should not return any type");
        assertEquals(0, getNumberOfWheels.getParameterCount(),
                "The method getNumberOfWheels should have no parameters");
        assertTrue(Modifier.isAbstract(getNumberOfWheels.getModifiers()),
                "The method getNumberOfWheels should be abstract");

        Method getMaxNumberOfPassengers = vehicleClass.getDeclaredMethod("getMaxNumberOfPassengers");
        assertEquals(Short.TYPE, getMaxNumberOfPassengers.getReturnType(),
                "The method getMaxNumberOfPassengers should not return any type");
        assertEquals(0, getMaxNumberOfPassengers.getParameterCount(),
                "The method getMaxNumberOfPassengers should have no parameters");
        assertTrue(Modifier.isAbstract(getMaxNumberOfPassengers.getModifiers()),
                "The method getMaxNumberOfPassengers should be abstract");
    }

    @Test
    void testMotorcycle() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Vehicle"),
                "Class Vehicle does not exist");
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Motorcycle"),
                "Class Motorcycle does not exist");
        Class<?> motorcycleClass = Class.forName("com.tsystems.autotestuni.basic.Motorcycle");
        Class<?> vehicleClass = Class.forName("com.tsystems.autotestuni.basic.Vehicle");
        motorcycleClass.isAssignableFrom(vehicleClass);
        Constructor<?> constructor = motorcycleClass.getConstructor();
        Object motorcycle = constructor.newInstance();

        Method getNumberOfWheels = motorcycleClass.getDeclaredMethod("getNumberOfWheels");
        assertEquals((byte) 2, getNumberOfWheels.invoke(motorcycle));

        Method getMaxNumberOfPassengers = motorcycleClass.getDeclaredMethod("getMaxNumberOfPassengers");
        assertEquals((short) 1, getMaxNumberOfPassengers.invoke(motorcycle));
    }

    @Test
    void testCar() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Vehicle"),
                "Class Vehicle does not exist");
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Car"),
                "Class Car does not exist");

        Class<?> carClass = Class.forName("com.tsystems.autotestuni.basic.Car");
        Class<?> vehicleClass = Class.forName("com.tsystems.autotestuni.basic.Vehicle");
        carClass.isAssignableFrom(vehicleClass);
        Class<?>[] types = {Short.TYPE};
        Constructor<?> constructor = carClass.getConstructor(types);
        Object[] args = { (short) 4 };
        Object car = constructor.newInstance(args);

        Method getNumberOfWheels = carClass.getDeclaredMethod("getNumberOfWheels");
        assertEquals((byte) 4, getNumberOfWheels.invoke(car));

        Method getMaxNumberOfPassengers = carClass.getDeclaredMethod("getMaxNumberOfPassengers");
        assertEquals(args[0], getMaxNumberOfPassengers.invoke(car));
    }

    @Test
    void testBus() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Vehicle"),
                "Class Vehicle does not exist");
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Bus"),
                "Class Bus does not exist");

        Class<?> busClass = Class.forName("com.tsystems.autotestuni.basic.Bus");
        Class<?> vehicleClass = Class.forName("com.tsystems.autotestuni.basic.Vehicle");
        busClass.isAssignableFrom(vehicleClass);
        Class<?>[] types = {Byte.TYPE, Short.TYPE};
        Constructor<?> constructor = busClass.getConstructor(types);
        Object[] args = { (byte) 10, (short) 4 };
        Object car = constructor.newInstance(args);

        Method getNumberOfWheels = busClass.getDeclaredMethod("getNumberOfWheels");
        assertEquals(args[0], getNumberOfWheels.invoke(car));

        Method getMaxNumberOfPassengers = busClass.getDeclaredMethod("getMaxNumberOfPassengers");
        assertEquals(args[1], getMaxNumberOfPassengers.invoke(car));
    }

    @Test
    void testEngine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Vehicle"),
                "Class Vehicle does not exist");
        assertDoesNotThrow(() -> Class.forName("com.tsystems.autotestuni.basic.Motorcycle"),
                "Class Motorcycle does not exist");
        Class<?> vehicleClass = Class.forName("com.tsystems.autotestuni.basic.Vehicle");
        Class<?> motorcycleClass = Class.forName("com.tsystems.autotestuni.basic.Motorcycle");

        motorcycleClass.isAssignableFrom(vehicleClass);
        Constructor<?> constructor = motorcycleClass.getConstructor();
        Object motorcycle = constructor.newInstance();

        Method startEngine = vehicleClass.getDeclaredMethod("startEngine");
        Method stopEngine = vehicleClass.getDeclaredMethod("stopEngine");
        Method isEngineStarted = vehicleClass.getDeclaredMethod("isEngineStarted");

        assertFalse((Boolean) isEngineStarted.invoke(motorcycle),
                "The field isEngineStarted should be false by default");
        startEngine.invoke(motorcycle);
        assertTrue((Boolean) isEngineStarted.invoke(motorcycle),
                "The field isEngineStarted should be true after the method startEngine is invoked");
        stopEngine.invoke(motorcycle);
        assertFalse((Boolean) isEngineStarted.invoke(motorcycle),
                "The field isEngineStarted should be false after the method stopEngine is invoked");
    }
}
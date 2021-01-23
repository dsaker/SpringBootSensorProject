package net.iwillwork4u.sensors.controller;

public class SensorNotFoundException extends RuntimeException {

    public SensorNotFoundException(Long id) {
        super("Could not find sensor " + id);
    }
}

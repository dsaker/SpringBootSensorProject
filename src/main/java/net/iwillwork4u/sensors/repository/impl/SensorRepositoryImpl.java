package net.iwillwork4u.sensors.repository.impl;

import net.iwillwork4u.sensors.entity.Sensor;
import org.springframework.stereotype.Repository;
import net.iwillwork4u.sensors.repository.sensor.SensorRepository;

@Repository
public class SensorRepositoryImpl implements SensorRepository {

    @Override
    public void create(Sensor sensor) {

    }

    @Override
    public Sensor read(Long id) {
        return null;
    }

    @Override
    public void update(Long id, Sensor user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void addMeasurement(Long sensorId, Long measurementId) {

    }

    @Override
    public void removeSensor(Long sensorId, Long measurementId) {

    }
}

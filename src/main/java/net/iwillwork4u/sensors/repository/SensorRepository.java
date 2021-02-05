package net.iwillwork4u.sensors.repository.sensor;

import net.iwillwork4u.sensors.entity.Sensor;

public interface SensorRepository {

    void create(Sensor sensor);

    Sensor read(Long id);

    void update(Long id, Sensor user);

    void delete(Long id);

    void addMeasurement(Long sensorId, Long measurementId);

    void removeSensor(Long sensorId, Long measurementId );

}

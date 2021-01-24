package net.iwillwork4u.sensors.repository.sensor;

import net.iwillwork4u.sensors.entity.Measurement;
import net.iwillwork4u.sensors.entity.Sensor;

public interface SensorRepositoryCustom {
    void addMeasurement(Sensor sensor, Measurement measurement);
    void removeMeasurement(Sensor sensor, Measurement measurement);
}

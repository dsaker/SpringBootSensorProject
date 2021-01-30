package net.iwillwork4u.sensors.repository.sensor;

import net.iwillwork4u.sensors.entity.Measurement;
import net.iwillwork4u.sensors.entity.Sensor;

public class SensorRepositoryCustomImpl implements SensorRepositoryCustom{
    @Override
    public void addMeasurement(Sensor sensor, Measurement measurement) {
        sensor.addMeasurement(measurement);
    }

    @Override
    public void removeMeasurement(Sensor sensor, Measurement measurement) {
        sensor.removeMeasurement(measurement);
    }

}

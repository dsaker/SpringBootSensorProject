package net.iwillwork4u.sensors.service;

import net.iwillwork4u.sensors.entity.Sensor;

import java.util.Map;
import java.util.Set;

public interface SensorService {

    Set<Sensor> getSensorsByFilter(Map<Long, Set<String>> filterParams);

    Sensor getSensorById(Long sensorId);

    void addSensor(Sensor sensor);
}

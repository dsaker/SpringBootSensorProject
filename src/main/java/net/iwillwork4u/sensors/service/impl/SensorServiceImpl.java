package net.iwillwork4u.sensors.service.impl;

import net.iwillwork4u.sensors.entity.Sensor;
import net.iwillwork4u.sensors.service.SensorService;
import org.springframework.stereotype.Service;
import net.iwillwork4u.sensors.repository.sensor.SensorRepository;

import java.util.Map;
import java.util.Set;

@Service
public class SensorServiceImpl implements SensorService {

    private SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Set<Sensor> getSensorsByFilter(Map<Long, Set<String>> filterParams) {
        return null;
    }

    @Override
    public Sensor getSensorById(Long sensorId) {
        return null;
    }

    @Override
    public void addSensor(Sensor sensor) {

    }
}

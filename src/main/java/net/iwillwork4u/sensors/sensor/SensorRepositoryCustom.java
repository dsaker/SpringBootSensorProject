package net.iwillwork4u.sensors.sensor;

import net.iwillwork4u.sensors.dto.SensorDataDto;

public interface SensorRepositoryCustom {
    void addSensorData(SensorDataDto sensorDataDto, Long id);
}

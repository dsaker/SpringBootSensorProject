package net.iwillwork4u.sensors.sensor;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.iwillwork4u.sensors.dto.SensorDataDto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SensorRepositoryCustomImpl implements SensorRepositoryCustom{

    private final SensorRepository sensorRepository;

    SensorRepositoryCustomImpl(SensorRepository repository) {
        this.sensorRepository = repository;
    }
    @Override
    public void addSensorData(SensorDataDto sensorDataDto, Long id)  {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() ->
                new SensorNotFoundException(id));
        sensor.setLastTemp(sensorDataDto.getTemp());

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("/data/s1data/s1data"), sensorDataDto);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

package net.iwillwork4u.sensors.controller.measurement;

import net.iwillwork4u.sensors.controller.sensor.SensorNotFoundException;
import net.iwillwork4u.sensors.entity.Measurement;
import net.iwillwork4u.sensors.repository.MeasurementRepository;
import net.iwillwork4u.sensors.entity.Sensor;
import net.iwillwork4u.sensors.repository.sensor.SensorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("measurements/")
public class MeasurementController {

    private final SensorRepository sensorRepository;

    private final MeasurementRepository measurementRepository;

    MeasurementController(SensorRepository sensorRepository, MeasurementRepository measurementRepository) {
        this.sensorRepository = sensorRepository;
        this.measurementRepository = measurementRepository;
    }

    @GetMapping()
    public List<Measurement> all() {
        return measurementRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity createMeasurement(
            @RequestParam long sensorId,
            @RequestParam double temperature,
            @RequestParam double humidity) {
        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow(() ->
                new SensorNotFoundException(sensorId));

        if(sensor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No sensor defined with the ID: " + sensorId);
        }

        Measurement measurement = new Measurement(
                sensor, temperature, humidity);

        measurementRepository.save(measurement);
        sensorRepository.addMeasurement(sensor, measurement);
        return ResponseEntity.ok().build();
    }
}

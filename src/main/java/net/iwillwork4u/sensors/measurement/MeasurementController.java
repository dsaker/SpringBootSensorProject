package net.iwillwork4u.sensors.measurement;

import net.iwillwork4u.sensors.sensor.Sensor;
import net.iwillwork4u.sensors.sensor.SensorNotFoundException;
import net.iwillwork4u.sensors.sensor.SensorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
            @RequestParam String key,
            @RequestParam double value) {
        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow(() ->
                new SensorNotFoundException(sensorId));

        if(sensor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No sensor defined with the ID: " + sensorId);
        }

        Measurement measurement = new Measurement(
                sensor, key, value);

        measurementRepository.save(measurement);

        return ResponseEntity.ok().build();
    }
}

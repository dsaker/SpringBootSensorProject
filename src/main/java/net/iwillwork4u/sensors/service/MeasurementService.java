package net.iwillwork4u.sensors.service;

import net.iwillwork4u.sensors.model.domain.Measurement;
import net.iwillwork4u.sensors.model.domain.Sensor;
import net.iwillwork4u.sensors.model.dto.MeasurementDto;
import net.iwillwork4u.sensors.repository.MeasurementRepository;
import net.iwillwork4u.sensors.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementService {

    private MeasurementRepository measurementRepository;
    private SensorRepository sensorRepository;

    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    public Optional<Measurement> findForId(Long id) {
        return measurementRepository.findById(id);
    }

    public Optional<Sensor> findSensorForId(Long id) {
        return sensorRepository.findById(id);
    }
}

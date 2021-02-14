package net.iwillwork4u.sensors.model.dto;

import net.iwillwork4u.sensors.model.domain.Measurement;

import java.time.LocalDateTime;

public class MeasurementDto {

    private Long id;
    private LocalDateTime timestamp;
    private Double temperature;
    private Double humidity;

    public MeasurementDto () {};

    public MeasurementDto(Measurement measurement) {
        this.id = measurement.getId();
        this.timestamp = measurement.getTimestamp();
        this.temperature = measurement.getTemperature();
        this.humidity = measurement.getHumidity();
    }
}

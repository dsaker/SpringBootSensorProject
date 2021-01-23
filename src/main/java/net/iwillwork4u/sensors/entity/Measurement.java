package net.iwillwork4u.sensors.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Measurement {

    @Id @GeneratedValue private Long id;

    @ManyToOne
    private Sensor sensor;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    //Key for the type of measurement, e.g. "temperature", "distance"...
    @Column(nullable = false)
    private String key;

    //Value of the measurement
    @Column(nullable = false)
    private double value;

    public Measurement() {
    }

    public Measurement(Sensor sensor, String key, double value) {
        this.sensor = sensor;
        this.key = key;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

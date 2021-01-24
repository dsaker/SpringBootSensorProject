package net.iwillwork4u.sensors.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Measurement {

    @Id @GeneratedValue private Long id;
    @ManyToOne
    private Sensor sensor;
    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
    @Column(nullable = false)
    private double temperature;
    @Column(nullable = false)
    private double humidity;

    public Measurement() {
    }

    public Measurement(Sensor sensor, double temp, double hum) {
        this.sensor = sensor;
        this.temperature = temp;
        this.humidity = hum;
    }

    public Measurement(Sensor sensor, LocalDateTime timestamp, double temperature, double humidity) {
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Double.compare(that.temperature, temperature) == 0 && Double.compare(that.humidity, humidity) == 0 && id.equals(that.id) && sensor.equals(that.sensor) && timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sensor, timestamp, temperature, humidity);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "sensor=" + sensor +
                ", timestamp=" + timestamp +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}

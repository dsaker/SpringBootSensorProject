package net.iwillwork4u.sensors.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SensorDataDto implements Serializable {

    private String sensorName;
    private Double temp;
    private Double humidity;
    private final LocalDateTime timeNow = LocalDateTime.now();

    public SensorDataDto(String sensorName, Double temp, Double humidity) {
        this.sensorName = sensorName;
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTimeNow() {
        return timeNow;
    }
}

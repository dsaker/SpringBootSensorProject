package net.iwillwork4u.sensors.model.dto;

import net.iwillwork4u.sensors.model.domain.Sensor;

public class SensorDto {

    private Long id;
    private String sensorName;
    private Integer htAlert;
    private Integer ltAlert;
    private Integer hhAlert;
    private Integer lhAlert;
    private Boolean tempAlertOn;
    private Boolean humAlertOn;
    private Integer timeBetweenAlerts;
    private Double lastTemp;

    public SensorDto () {};

    public SensorDto(Sensor sensor) {
        this.id = sensor.getId();
        this.sensorName = sensor.getSensorName();
        this.htAlert = sensor.getHtAlert();
        this.ltAlert = sensor.getLtAlert();
        this.hhAlert = sensor.getHhAlert();
        this.lhAlert = sensor.getLhAlert();
        this.tempAlertOn = sensor.getTempAlertOn();
        this.humAlertOn = sensor.getHumAlertOn();
        this.timeBetweenAlerts = sensor.getTimeBetweenAlerts();
        this.lastTemp = sensor.getLastTemp();
    }
}

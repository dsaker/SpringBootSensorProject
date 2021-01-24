package net.iwillwork4u.sensors.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sensor {

    private @Id @GeneratedValue Long sid;
    @Size(min=5, max=50, message="{Size.Sensor.name.validation")
    private String name;
    private Integer htAlert = 90;
    private Integer ltAlert = 40;
    private Integer hhAlert = 80;
    private Integer lhAlert = 35;
    private Boolean tempAlertOn = true;
    private Boolean humAlertOn = true;
    private Integer timeBetween = 1;
    private LocalDateTime alertTriggered = LocalDateTime.now().minusYears(1);
    private Double lastTemp = 0.0;
    @ManyToOne
    private User user;
    @OneToMany(
            mappedBy = "sensor",
            cascade = {CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private Set<Measurement> measurements = new HashSet<>();


    public Sensor(String name, Integer htAlert, Integer ltAlert, Integer hhAlert, Integer lhAlert, Boolean tempAlertOn, Boolean humAlertOn, Integer timeBetween, LocalDateTime alertTriggered, Double lastTemp, User user) {
        this.name = name;
        this.htAlert = htAlert;
        this.ltAlert = ltAlert;
        this.hhAlert = hhAlert;
        this.lhAlert = lhAlert;
        this.tempAlertOn = tempAlertOn;
        this.humAlertOn = humAlertOn;
        this.timeBetween = timeBetween;
        this.alertTriggered = alertTriggered;
        this.lastTemp = lastTemp;
        this.user = user;
    }

    public Sensor() { }

    public Sensor(String name) {
        this.name = name;;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long id) {
        this.sid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHtAlert() {
        return htAlert;
    }

    public void setHtAlert(Integer ht_alert) {
        this.htAlert = ht_alert;
    }

    public Integer getLtAlert() {
        return ltAlert;
    }

    public void setLtAlert(Integer lt_alert) {
        this.ltAlert = lt_alert;
    }

    public Integer getHhAlert() {
        return hhAlert;
    }

    public void setHhAlert(Integer hh_alert) {
        this.hhAlert = hh_alert;
    }

    public Integer getLhAlert() {
        return lhAlert;
    }

    public void setLhAlert(Integer lh_alert) {
        this.lhAlert = lh_alert;
    }

    public Boolean getTempAlertOn() {
        return tempAlertOn;
    }

    public void setTempAlertOn(Boolean temp_alert_on) {
        this.tempAlertOn = temp_alert_on;
    }

    public Boolean getHumAlertOn() {
        return humAlertOn;
    }

    public void setHumAlertOn(Boolean hum_alert_on) {
        this.humAlertOn = hum_alert_on;
    }

    public Integer getTimeBetween() {
        return timeBetween;
    }

    public void setTimeBetween(Integer time_between) {
        this.timeBetween = time_between;
    }

    public LocalDateTime getAlertTriggered() {
        return alertTriggered;
    }

    public void setAlertTriggered(LocalDateTime alert_triggered) {
        this.alertTriggered = alert_triggered;
    }

    public Double getLastTemp() {
        return lastTemp;
    }

    public void setLastTemp(Double last_temp) {
        this.lastTemp = last_temp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Measurement> getDataEntries() {
        return measurements;
    }

    public void setDataEntries(Set<Measurement> dataEntries) {
        this.measurements = dataEntries;
    }

    public void addMeasurement(Measurement measurement) {
        measurements.add(measurement);
        measurement.setSensor(this);
    }

    public void removeMeasurement(Measurement measurement) {
        measurements.remove(measurement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(sid, sensor.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, name, htAlert, ltAlert, hhAlert, lhAlert, tempAlertOn, humAlertOn, timeBetween, alertTriggered, lastTemp, user);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + sid +
                ", name='" + name + '\'' +
                ", high temp alert=" + htAlert +
                ", low temp alert=" + ltAlert +
                ", high humidity alert=" + hhAlert +
                ", low humidity alert=" + lhAlert +
                ", temperature alert on=" + tempAlertOn +
                ", humidity alert on=" + humAlertOn +
                ", time between alerts=" + timeBetween +
                ", alert triggered at=" + alertTriggered +
                ", last temperature recorded=" + lastTemp +
                '}';
    }
}

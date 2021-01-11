package net.iwillwork4u.sensors.sensor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.iwillwork4u.sensors.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Sensor {

    private @Id @GeneratedValue
    Long sid;
    private String name;
    private Integer htAlert = 90;
    private Integer ltAlert = 40;
    private Integer hhAlert = 80;
    private Integer lhAlert = 35;
    private Boolean tempAlertOn = true;
    private Boolean humAlertOn = true;
    private Integer timeBetween = 1;
    private LocalDate alertTriggered = LocalDate.now().minusYears(1);
    private double lastTemp = 0.0;
    @ManyToOne
    private User user;

    public Sensor(String name, Integer htAlert, Integer ltAlert, Integer hhAlert, Integer lhAlert, Boolean tempAlertOn, Boolean humAlertOn, Integer timeBetween, LocalDate alertTriggered, Float lastTemp, User user) {
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

    public Sensor(Long sid, String name, Integer htAlert, Integer ltAlert, Integer hhAlert, Integer lhAlert, Boolean tempAlertOn, Boolean humAlertOn, Integer timeBetween, LocalDate alertTriggered, double lastTemp, User user) {
        this.sid = sid;
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

    public LocalDate getAlertTriggered() {
        return alertTriggered;
    }

    public void setAlertTriggered(LocalDate alert_triggered) {
        this.alertTriggered = alert_triggered;
    }

    public double getLastTemp() {
        return lastTemp;
    }

    public void setLastTemp(Float last_temp) {
        this.lastTemp = last_temp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

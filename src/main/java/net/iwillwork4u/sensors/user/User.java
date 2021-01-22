package net.iwillwork4u.sensors.user;

import net.iwillwork4u.sensors.sensor.Sensor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    private @Id @GeneratedValue Long uid;
    private String name;
    private String phoneNumber;
    private String carrier;
    @OneToMany(targetEntity = Sensor.class)
    private Set<Sensor> sensorSet = new HashSet<>();

    public User(String name, String phonenumber, String carrier) {
        this.name = name;
        this.phoneNumber = phonenumber;
        this.carrier = carrier;
    }

    protected User() { }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long id) {
        this.uid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void addSensor(Sensor sensor) {
        sensorSet.add(sensor);
        sensor.setUser(this);
    }

    public void removeSensor(Sensor sensor) {
        sensorSet.remove(sensor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(name, user.name) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(carrier, user.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, phoneNumber, carrier);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + uid +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }
}

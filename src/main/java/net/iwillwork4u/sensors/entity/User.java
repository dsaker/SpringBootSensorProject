package net.iwillwork4u.sensors.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String phoneNumber;
    private String carrier;
/*    @OneToMany(
            mappedBy = "sensor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Sensor> sensors = new ArrayList<>();*/


    public User(String name, String phonenumber, String carrier) {
        this.name = name;
        this.phoneNumber = phonenumber;
        this.carrier = carrier;
    }

    protected User() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

/*    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
        sensor.setUser(this);
    }

    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
        sensor.setUser(null);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(carrier, user.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, carrier);
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }
}

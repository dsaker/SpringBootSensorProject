package net.iwillwork4u.sensors.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "sensor")
@Getter @Setter @NoArgsConstructor
public class Sensor {

    @Id
    @Column(name = "sensor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5, max=30)
    @Column(name = "sensor_name", nullable = false)
    private String sensorName;
    @Column(name = "htAlert")
    private Integer htAlert = 90;
    @Column(name = "ltAlert")
    private Integer ltAlert = 40;
    @Column(name = "hhAlert")
    private Integer hhAlert = 80;
    @Column(name = "lhAlert")
    private Integer lhAlert = 35;
    @Column(name = "tempAlertOn")
    private Boolean tempAlertOn = true;
    @Column(name = "humAlertOn")
    private Boolean humAlertOn = true;
    @Column(name = "timeBetweenAlerts")
    private Integer timeBetweenAlerts = 1;
    @Column(name = "alertTriggered")
    private LocalDateTime alertTriggered = LocalDateTime.now().minusYears(1);
    @Column(name = "lastTemp")
    private Double lastTemp = 0.0;
    @ManyToOne
    @JoinColumn(name="uid", referencedColumnName = "user_id", nullable = false)
    private User user;
    @OneToMany( mappedBy = "sensor", cascade = CascadeType.REMOVE)
    private Set<Measurement> measurements;


    public Sensor(String sensorName, Integer htAlert, Integer ltAlert, Integer hhAlert, Integer lhAlert, Boolean tempAlertOn, Boolean humAlertOn, Integer timeBetweenAlerts, LocalDateTime alertTriggered, Double lastTemp, User user) {
        this.sensorName = sensorName;
        this.htAlert = htAlert;
        this.ltAlert = ltAlert;
        this.hhAlert = hhAlert;
        this.lhAlert = lhAlert;
        this.tempAlertOn = tempAlertOn;
        this.humAlertOn = humAlertOn;
        this.timeBetweenAlerts = timeBetweenAlerts;
        this.alertTriggered = alertTriggered;
        this.lastTemp = lastTemp;
        this.user = user;
    }

    public Sensor(Long id) {
        this.id = id;
    }
}

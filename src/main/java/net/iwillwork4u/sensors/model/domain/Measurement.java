package net.iwillwork4u.sensors.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
@Getter @Setter @NoArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "sensor_id", nullable = false)
    private Sensor sensor;
    @Column(name = "timestamp",nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
    @Column(name = "temperature", nullable = false)
    private Double temperature;
    @Column(name = "humidity", nullable = false)
    private Double humidity;

}

package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}

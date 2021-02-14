package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.model.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SensorRepository extends JpaRepository<Sensor, Long> {
}

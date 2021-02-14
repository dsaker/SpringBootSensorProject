package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.model.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    public Optional<List<Measurement>> findBySensorId(Long sensorid);
}

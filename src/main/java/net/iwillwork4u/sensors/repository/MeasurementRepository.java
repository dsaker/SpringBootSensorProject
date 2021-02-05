package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.entity.Measurement;

public interface MeasurementRepository {

    void create(Measurement measurement);

    Measurement read(Long id);

    void update(Long id, Measurement measurement);

    void delete(Long id);

}

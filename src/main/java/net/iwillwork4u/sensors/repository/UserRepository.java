package net.iwillwork4u.sensors.repository.user;

import net.iwillwork4u.sensors.entity.User;

public interface UserRepository {

	void create(User user);

    User read(Long id);

    void update(Long id, User user);

    void delete(Long id);

    void addSensor(Long userId, Long sensorId);

    void removeSensor(Long userId, Long sensorId );

}

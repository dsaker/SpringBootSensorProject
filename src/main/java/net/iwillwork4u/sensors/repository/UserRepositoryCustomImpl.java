package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.entity.Sensor;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Override
    public User addSensor(Sensor sensor, User user) {
        user.addSensor(sensor);
        return user;
    }

    @Override
    public User removeSensor(Sensor sensor, User user) {
        user.removeSensor(sensor);
        return user;
    }
}

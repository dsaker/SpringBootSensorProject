package net.iwillwork4u.sensors.repository.user;

import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.entity.Sensor;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @Override
    public void addSensor(Sensor sensor, User user) {
        user.addSensor(sensor);
    }

    @Override
    public void removeSensor(Sensor sensor, User user) {
        user.removeSensor(sensor);
    }
}

package net.iwillwork4u.sensors.user;

import net.iwillwork4u.sensors.sensor.Sensor;

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

package net.iwillwork4u.sensors.repository.user;

import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.entity.Sensor;

interface UserRepositoryCustom {
    void addSensor(Sensor sensor, User user);
    void removeSensor(Sensor sensor, User user);
}

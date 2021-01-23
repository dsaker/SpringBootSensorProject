package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.entity.Sensor;

interface UserRepositoryCustom {
    User addSensor(Sensor sensor, User user);
    User removeSensor(Sensor sensor, User user);
}

package net.iwillwork4u.sensors.user;

import net.iwillwork4u.sensors.sensor.Sensor;

interface UserRepositoryCustom {
    User addSensor(Sensor sensor, User user);
    User removeSensor(Sensor sensor, User user);
}

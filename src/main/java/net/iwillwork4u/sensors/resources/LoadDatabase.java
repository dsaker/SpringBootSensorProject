package net.iwillwork4u.sensors.resources;

import net.iwillwork4u.sensors.entity.Sensor;
import net.iwillwork4u.sensors.repository.SensorRepository;
import net.iwillwork4u.sensors.entity.User;
import net.iwillwork4u.sensors.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public SensorRepository sensorRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        sensorRepository.deleteAll();
        User u1 = new User("Bilbo", "5555555555", "Sprint");
        User u2 = new User("Fred", "5555555551", "Verizon");

        Sensor s1 = new Sensor("s1");
        Sensor s2 = new Sensor("s2");
        Sensor s3 = new Sensor("s3");
        Sensor s4 = new Sensor("s4");
        Sensor s5 = new Sensor("s5");
        log.info("Preloading " + sensorRepository.save(s1));
        log.info("Preloading " + sensorRepository.save(s2));
        log.info("Preloading " + sensorRepository.save(s3));
        log.info("Preloading " + sensorRepository.save(s4));
        log.info("Preloading " + sensorRepository.save(s5));
        userRepository.addSensor(s1, u1);
        userRepository.addSensor(s2, u2);
        userRepository.addSensor(s3, u1);
        userRepository.addSensor(s4, u2);
        userRepository.addSensor(s5, u1);
        log.info("Preloading " + userRepository.save(u1));
        log.info("Preloading " + userRepository.save(u2));
    }
}

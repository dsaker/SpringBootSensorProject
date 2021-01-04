package net.iwillwork4u.sensors;

import net.iwillwork4u.sensors.sensor.Sensor;
import net.iwillwork4u.sensors.sensor.SensorRepository;
import net.iwillwork4u.sensors.user.User;
import net.iwillwork4u.sensors.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        sensorRepository.deleteAll();
        User u1 = new User("Bilbo", "5555555555", "Sprint");
        User u2 = new User("Fred", "5555555551", "Verizon");
        log.info("Preloading " + userRepository.save(u1));
        log.info("Preloading " + userRepository.save(u2));
        log.info("Preloading " + sensorRepository.save(new Sensor("s1", u1)));
        log.info("Preloading " + sensorRepository.save(new Sensor("s2", u2)));
        log.info("Preloading " + sensorRepository.save(new Sensor("s3", u1)));
        log.info("Preloading " + sensorRepository.save(new Sensor("s4", u1)));
    }
}

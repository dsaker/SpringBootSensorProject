package net.iwillwork4u.sensors.resources;

import net.iwillwork4u.sensors.repository.MeasurementRepository;
import net.iwillwork4u.sensors.repository.SensorRepository;
import net.iwillwork4u.sensors.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    private final UserRepository userRepository;
    private final SensorRepository sensorRepository;
    private final MeasurementRepository measurementRepository;

    LoadDatabase(UserRepository userRepository, SensorRepository sensorRepository, MeasurementRepository measurementRepository) {
        this.userRepository = userRepository;
        this.sensorRepository = sensorRepository;
        this.measurementRepository = measurementRepository;
    }

    int numMeasurements = 50;
    @Override
    public void run(String... args) throws Exception {
 /*       userRepository.deleteAll();
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
        //add measurements to each sensor
        Sensor[] sensorArray ={s1,s2,s3,s4};
        for (Sensor s:sensorArray) {
            LocalDateTime dateTime = LocalDateTime.now();
            int j=0;
            int i=0;
            int delta=0;
            while(j<1000){
                if(i==0) delta = 1;
                if(i==100) delta = -1;
                i+=delta;
                dateTime = dateTime.plusMinutes(5);
                Measurement m = new Measurement(s, dateTime, i, i);
                measurementRepository.save(m);
                sensorRepository.addMeasurement(s, m);
                j++;
            }
        }

        userRepository.addSensor(s1, u1);
        userRepository.addSensor(s2, u2);
        userRepository.addSensor(s3, u1);
        userRepository.addSensor(s4, u2);
        userRepository.addSensor(s5, u1);
        log.info("Preloading " + userRepository.save(u1));
        log.info("Preloading " + userRepository.save(u2));
    */
    }
}

package net.iwillwork4u.sensors.service;

import net.iwillwork4u.sensors.model.domain.User;
import net.iwillwork4u.sensors.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {

    private Logger log = (Logger) LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;

    public User createUser(String )
}

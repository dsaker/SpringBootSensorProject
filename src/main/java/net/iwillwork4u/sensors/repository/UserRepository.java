package net.iwillwork4u.sensors.repository;

import net.iwillwork4u.sensors.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}

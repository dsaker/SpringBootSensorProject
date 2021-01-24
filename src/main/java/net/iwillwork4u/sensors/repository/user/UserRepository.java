package net.iwillwork4u.sensors.repository.user;

import net.iwillwork4u.sensors.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}

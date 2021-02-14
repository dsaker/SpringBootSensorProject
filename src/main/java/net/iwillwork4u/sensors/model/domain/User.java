package net.iwillwork4u.sensors.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwillwork4u.sensors.common.util.PhoneProvider;
import net.iwillwork4u.sensors.model.BaseModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.security.AuthProvider;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter @Setter @NoArgsConstructor
public class User extends BaseModel{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5, max=30)
    @Column(name= "user_name",nullable = false)
    private String userName;
    @Size(min = 5, max = 30)
    @Column(name = "email", length = 30, unique = true, nullable = false)
    private String email;
    @JsonIgnore
    @Size(min = 60, max= 60)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "carrier")
    private PhoneProvider carrier;
    @OneToMany(mappedBy = "user")
    private Set<Sensor> sensorSet;

    public User(String userName, String phonenumber, PhoneProvider carrier) {
        this.userName = userName;
        this.phoneNumber = phonenumber;
        this.carrier = carrier;
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}

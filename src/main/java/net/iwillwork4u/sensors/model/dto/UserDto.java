package net.iwillwork4u.sensors.model.dto;

import lombok.Data;
import net.iwillwork4u.sensors.common.util.PhoneProvider;

import java.time.LocalDateTime;

public class UserDto {

    @Data
    public static class Create {
        private Long id;
        private String userName;
        private String email;
/*        private String password;*/
        private String phoneNumber;
        private PhoneProvider carrier;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;
    }

    @Data
    public static class Update {
        private Long id;
        private String email;
        private String phoneNumber;
        private PhoneProvider carrier;
    }

}

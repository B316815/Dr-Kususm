package com.Doctors.Payload;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String mobile;
    private String password;
}

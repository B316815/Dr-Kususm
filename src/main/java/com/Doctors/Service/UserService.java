package com.Doctors.Service;

import com.Doctors.Payload.UserDto;

import java.util.List;

public interface UserService {
    public UserDto addUser(UserDto userDto);

    public UserDto updateUser( Long id,UserDto userDto);
    public UserDto getUserById(Long id);
    public List<UserDto> getAllUsers();
    public void deleteUser(Long id);

    public UserDto updatePassword(String username, UserDto userDto);

}

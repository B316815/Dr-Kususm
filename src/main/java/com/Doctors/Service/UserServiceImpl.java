package com.Doctors.Service;

import com.Doctors.Entity.User;
import com.Doctors.Payload.UserDto;
import com.Doctors.Repository.UserRepository;
import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
       User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedDoctor = userRepository.save(user);
        return modelMapper.map(savedDoctor, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user ;
                user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
       user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            User updated = userRepository.save(user);
            return modelMapper.map(updated,UserDto.class);
    }

//    @Override
//    public UserDto updateUser(Long id, UserDto userDto) {
//        Optional<User> optionalUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//        if(optionalUser.isPresent()){
//            User user = optionalUser.get();
//            modelMapper.map(userDto, User.class);
//            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//            User updated = userRepository.save(user);
//            return modelMapper.map(updated,UserDto.class);
//        }else{
//            System.out.println("User Not Present");
//        }
//        return null;
//    }

    @Override
    public UserDto getUserById(Long id) {
        User byId = userRepository.getById(id);
        return modelMapper.map(byId, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public UserDto updatePassword(String username, UserDto userDto) {
        User user;
        user=userRepository.findByUsername(username);
//        .orElseThrow(() -> new RuntimeException("Username Not Present"));
//                .orElseThrow(() -> new RuntimeException("Username Not Present") ));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDto.class);

    }

}

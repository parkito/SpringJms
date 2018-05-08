package ru.siksmfp.spring.jms.consumer.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.siksmfp.spring.jms.consumer.entity.Role;
import ru.siksmfp.spring.jms.consumer.entity.UserEntity;
import ru.siksmfp.spring.jms.consumer.repository.impl.UserRepository;
import ru.siksmfp.spring.jms.dto.entity.UserDto;

import java.util.List;

@Service
public class UsersService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }

    public void save(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setSecondName(user.getSecondName());
        userEntity.setRole(convertRole(user.getRole()));

        userRepository.save(userEntity);
        LOGGER.info("User saved {}", userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }

    private Role convertRole(UserDto.Role role) {
        switch (role) {
            case USER:
                return Role.USER;
            case ADMIN:
                return Role.ADMIN;
            case ROOT:
                return Role.ROOT;
            default:
                return Role.USER;
        }
    }
}

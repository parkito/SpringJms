package ru.siksmfp.spring.jms.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.siksmfp.spring.jms.publisher.entity.Role;
import ru.siksmfp.spring.jms.publisher.entity.UserEntity;
import ru.siksmfp.spring.jms.publisher.repository.impl.UserRepository;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }

    public void createUser(String email, String firstName, String secondName, String password) {
        UserEntity newUser = new UserEntity(email, firstName, secondName, password, Role.USER);
        userRepository.save(newUser);
    }

    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }
}

package com.example.springApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.springApp.data.local.repository.UserRepository;
import com.example.springApp.data.local.entities.UserEntity;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity updateUser(Long id, UserEntity userEntityDetails) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userEntity.setName(userEntityDetails.getName());
        userEntity.setAge(userEntityDetails.getAge());
        userEntity.setEmail(userEntityDetails.getEmail());
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

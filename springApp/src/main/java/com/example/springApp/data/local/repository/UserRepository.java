package com.example.springApp.data.local.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springApp.data.local.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

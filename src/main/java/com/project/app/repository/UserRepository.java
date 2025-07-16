package com.project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

package com.project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.entity.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {

}

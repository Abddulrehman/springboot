package com.socialmediablogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmediablogapi.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}

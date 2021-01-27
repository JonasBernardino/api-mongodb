package com.jonasbernardino.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jonasbernardino.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

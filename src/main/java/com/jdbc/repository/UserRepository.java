package com.jdbc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jdbc.entity.User;

public interface UserRepository extends MongoRepository<User,String>{

}

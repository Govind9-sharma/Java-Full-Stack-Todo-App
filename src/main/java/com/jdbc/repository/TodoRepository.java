package com.jdbc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jdbc.entity.Todo;


public interface TodoRepository extends MongoRepository<Todo,String>{

}

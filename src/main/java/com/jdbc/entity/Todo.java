package com.jdbc.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document("todos")
@Data
public class Todo {
	@Id
	String id;
//    @NonNull
	String userid;
	String data;
	Date date;
}


//http://127.0.0.1:8081/todo/create
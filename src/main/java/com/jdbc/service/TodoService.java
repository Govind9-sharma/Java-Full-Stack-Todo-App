package com.jdbc.service;


import java.util.List;

import com.jdbc.entity.Todo;

public interface TodoService {
	
	public Todo createTodo(Todo todo);
	public Todo getById(String id);
	public void deleteById(String id);
	public List<Todo> getAll();
	public Todo updateTodo(Todo todo);
	public void deleteAll();
}
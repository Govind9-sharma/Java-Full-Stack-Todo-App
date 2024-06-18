package com.jdbc.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.entity.Todo;
import com.jdbc.service.TodoService;

@CrossOrigin("https://full-stack-project-8b5c7.web.app/")
@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable String id)
	{
		Todo todo=service.getById(id);
		return ResponseEntity.ok(todo);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo)
	{
		String id=UUID.randomUUID().toString();
		todo.setId(id);
		return ResponseEntity.ok(service.createTodo(todo));
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<HttpStatus> deleteTodoById(@PathVariable String id)
	{
		service.deleteById(id);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getalltodo")
	public ResponseEntity<List<Todo>> getAllTodo()
	{
	    return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping("/updatetodo")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo)
	{
		Todo prev=service.getById(todo.getId());
		
		if(todo.getData()==null)
		{
			todo.setData(prev.getData());
		}
		if(todo.getDate()==null)
		{
			todo.setDate(prev.getDate());
		}
		if(todo.getUserid()==null)
		{
			todo.setUserid(prev.getUserid());
		}
	    return ResponseEntity.ok(service.updateTodo(todo));	
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<HttpStatus> deleteAll()
	{
		service.deleteAll();
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
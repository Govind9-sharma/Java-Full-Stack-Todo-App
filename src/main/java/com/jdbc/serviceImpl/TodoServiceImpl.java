package com.jdbc.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.entity.Todo;
import com.jdbc.service.TodoService;
import com.jdbc.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService
{

	@Autowired
	TodoRepository repository;
	
	@Override
	public Todo createTodo(Todo todo) {
		// TODO Auto-generated method stub
		Todo todo1=repository.save(todo);
		return todo1;
	}

	@Override
	public Todo getById(String id) {
		// TODO Auto-generated method stub
	    Optional<Todo> todo=repository.findById(id);
		return todo.get();
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Todo> getAll() {
		// TODO Auto-generated method stub
		Iterable<Todo> itr=repository.findAll();
		Iterator<Todo> itr1=itr.iterator();
		List<Todo> todoList=new ArrayList();
		while(itr1.hasNext())
		{
			todoList.add(itr1.next());
		}
		return todoList;
	}

	@Override
	public Todo updateTodo(Todo todo) {

		return repository.save(todo);
	}

	@Override
	public void deleteAll() {
		
		repository.deleteAll();
	}

}

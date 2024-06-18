package com.jdbc.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.entity.User;
import com.jdbc.repository.UserRepository;
import com.jdbc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public User createUser(User user) {

		User u=repository.save(user);
		return u;
	}

	@Override
	public List<User> getAllUser() {
         
		Iterable<User> itr=repository.findAll();
		Iterator<User> itr1=itr.iterator();
		List<User> userList=new ArrayList();
		while(itr1.hasNext())
		{
			userList.add(itr1.next());
		}
		return userList;
	}
   
}
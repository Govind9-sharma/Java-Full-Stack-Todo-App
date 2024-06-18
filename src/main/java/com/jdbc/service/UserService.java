package com.jdbc.service;

import java.util.List;

import com.jdbc.entity.User;

public interface UserService 
{
	public User createUser(User user);
	
	public List<User> getAllUser();
}
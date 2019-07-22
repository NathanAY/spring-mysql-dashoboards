package com.inventory.service;

import com.inventory.model.User;

public interface UserService {
	void save(User user);
	
	User findByUsername(String username);

}

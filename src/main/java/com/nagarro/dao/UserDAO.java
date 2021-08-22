package com.nagarro.dao;

import com.nagarro.dto.User;

public interface UserDAO {

	public void saveUser();

	public User getUser(String username);

}

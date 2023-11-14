package com.nbagmsimulator.springmvc.dao;

import java.util.List;

import com.nbagmsimulator.springmvc.api.model.User;

public interface UserDao {
	
	User findById(long id);

    User findByUsername(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers(); 

    void deleteAllUsers();

    public boolean isUserExist(User user);

}

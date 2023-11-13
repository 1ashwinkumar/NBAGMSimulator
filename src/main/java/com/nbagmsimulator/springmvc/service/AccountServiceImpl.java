package com.nbagmsimulator.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbagmsimulator.springmvc.api.model.User;
import com.nbagmsimulator.springmvc.dao.UserDao;
import com.nbagmsimulator.springmvc.model.UserImpl;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private UserDao userDao;

	@Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

	@Override
    public User findById(long id) {
		return userDao.findById(id);
    }

	@Override
    public User findByUsername(String name) {
		return userDao.findByUsername(name);
    }

	@Override
	@Transactional
    public void saveUser(User user) {
    	userDao.saveUser(user);
    }

	@Override
	@Transactional
    public void updateUser(User user) {
		userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public boolean isUserExist(User user) {
        return userDao.isUserExist(user);
    }

    @Override
    @Transactional
    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }

}
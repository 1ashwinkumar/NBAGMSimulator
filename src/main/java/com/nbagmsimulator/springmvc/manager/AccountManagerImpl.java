package com.nbagmsimulator.springmvc.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.nbagmsimulator.springmvc.api.manager.AccountManager;
import com.nbagmsimulator.springmvc.api.model.User;
import com.nbagmsimulator.springmvc.service.AccountService;
import com.nbagmsimulator.springmvc.view.UserView;

@Service
public class AccountManagerImpl implements AccountManager{
	@Autowired
	private AccountService accountService;

	@Override
	public User findById(long id) {
		User userImpl = accountService.findById(id);
        return userImpl;
	}

	@Override
	public User findByUsername(String name) {
		User userImpl = accountService.findByUsername(name);
        return userImpl;
	}

	@Override
	public void saveUser(User user) {
		accountService.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		accountService.updateUser(user);
	}

	@Override
	public void deleteUserById(long id) {
		accountService.deleteUserById(id);
	}

	@Override
	public List<User> findAllUsers() {
		List<User> userList = accountService.findAllUsers();
		List<UserView> userViewList = new ArrayList<UserView>();
		for (User user : userList) {
			userViewList.add(UserView.convert(user));
		}
		return ImmutableList.copyOf(userViewList);
	}

	@Override
	public void deleteAllUsers() {
		accountService.deleteAllUsers();
	}

	@Override
	public boolean isUserExist(User user) {
		return accountService.isUserExist(user);
	}

}

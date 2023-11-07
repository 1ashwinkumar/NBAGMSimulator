package com.nbagmsimulator.springmvc.service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nbagmsimulator.springmvc.model.Coach;
import com.nbagmsimulator.springmvc.model.Player;
import com.nbagmsimulator.springmvc.model.User;

@Service
public class AccountServiceImpl implements AccountService{

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static{
        users=populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(long id) {
        for(User user: users)
            if(user.getId() == id)
                return user;
        return null;
    }

    public User findByUsername(String name) {
        for(User user: users)
            if(user.getUsername().equalsIgnoreCase(name))
                return user;
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isUserExist(User user) {
        return findByUsername(user.getUsername())!=null;
    }

    public void deleteAllUsers(){
        users.clear();
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        List<Player> emptyPlayers = new ArrayList<Player>();
        List<Coach> emptyCoaches = new ArrayList<Coach>();
        users.add(new User(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com", "76ers", emptyPlayers, emptyCoaches));
        users.add(new User(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com", "Suns", emptyPlayers, emptyCoaches));
        users.add(new User(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com", "Raptors", emptyPlayers, emptyCoaches));
        return users;
    }

}
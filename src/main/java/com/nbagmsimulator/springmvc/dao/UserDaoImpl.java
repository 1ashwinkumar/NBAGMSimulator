package com.nbagmsimulator.springmvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nbagmsimulator.springmvc.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
    SessionFactory sessionFactory;

    @Autowired
    HibernateTemplate hibernateTemplate;

	@Override
	public User findById(long id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public User findByUsername(String username) {
		String hql = "FROM User p WHERE p.username = :username"; // HQL Query
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setParameter("username", username);
        return (User) query.uniqueResult();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		User resultingUser = hibernateTemplate.load(User.class, user.getId());
        resultingUser.setId(user.getId());
        resultingUser.setUsername(user.getUsername());
        resultingUser.setAddress(user.getAddress());
        resultingUser.setEmail(user.getEmail());
        hibernateTemplate.update(resultingUser);
	}

	@Override
	public void deleteUserById(long id) {
		Query query = sessionFactory.openSession().createSQLQuery("DELETE FROM User WHERE id = :id");
        query.setLong("id", id);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class); // Criteria Query
        return (List<User>) criteria.list();
	}

	@Override
	@Transactional
	public void deleteAllUsers() {
		sessionFactory.openSession().createQuery("DELETE FROM User").executeUpdate();
	}

	@Override
	public boolean isUserExist(User user) {
		Query query = sessionFactory.openSession().createQuery("FROM User p WHERE p.username = :username");
    	query.setString("username", user.getUsername());
    	List<?> userList = query.list();
    	if (userList.isEmpty()) {
    		return false;
    	}
    	return true;
	}

}

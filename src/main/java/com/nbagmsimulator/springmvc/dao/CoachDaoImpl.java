package com.nbagmsimulator.springmvc.dao;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.nbagmsimulator.springmvc.model.Coach;


public class CoachDaoImpl implements CoachDao{
	
	@Autowired
    SessionFactory sessionFactory;

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
	public Coach findById(long id) {
		String hql = "FROM Coach c WHERE c.id = :id"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("id", id);
		return (Coach) query.uniqueResult();
	}

	@Override
	public Coach findByName(String name) {
		String hql = "FROM Coach c WHERE c.name = :name"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("name", name);
		return (Coach) query.uniqueResult();
	}

	@Override
	@Transactional
	public Coach hireNewCoach(Coach coach) {
		hibernateTemplate.save(coach);
		return coach;
	}

	@Override
	@Transactional
	public Coach hireExistingCoach(Coach coach) {
		Coach resultingCoach = hibernateTemplate.load(Coach.class, coach.getId());
		resultingCoach.setId(coach.getId());
        resultingCoach.setName(coach.getName());
        resultingCoach.setIsHeadCoach(coach.getIsHeadCoach());
        resultingCoach.setTeam(coach.getTeam());
        resultingCoach.setOffRating(coach.getOffRating());
        resultingCoach.setDefRating(coach.getDefRating());
        resultingCoach.setContractLength(coach.getContractLength());
        resultingCoach.setSalary(coach.getSalary());
        hibernateTemplate.update(resultingCoach);
        return resultingCoach;
	}

	@Override
	@Transactional
	public Coach fireCoach(long id) {
		Coach resultingCoach = hibernateTemplate.load(Coach.class, id);
        resultingCoach.setTeam(null);
        resultingCoach.setContractLength(null);
        resultingCoach.setSalary(null);
        hibernateTemplate.update(resultingCoach);
        return resultingCoach;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Coach> getAllCoaches() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Coach.class); // Criteria Query
		return (List<Coach>) criteria.list();
	}

	@Override
	public boolean isCoachExist(Coach coach) {
		Query query = sessionFactory.openSession().createQuery("FROM Coach c WHERE c.name = :name");
    	query.setString("name", coach.getName());
    	List<?> cList = query.list();
    	if (cList.isEmpty()) {
    		return false;
    	}
    	return true;
	}
	
	@Override
	public boolean isHeadCoach(Coach coach) {
		Query query = sessionFactory.openSession().createQuery("FROM Coach c WHERE c.isHeadCoach = true");
    	query.setString("name", coach.getName());
    	List<?> cList = query.list();
    	if (cList.isEmpty()) {
    		return false;
    	}
    	return true;
	}

	@Override
	public Coach getHeadCoach() {
		Query query = sessionFactory.openSession().createQuery("FROM Coach c WHERE c.isHeadCoach = true");
    	List<?> cList = query.list();
    	if (cList.isEmpty()) {
    		return (Coach) cList.get(0);
    	}
    	return null;
	}
	
	@Override
	@Transactional
	public boolean deleteCoachById(long id) {
		Query query = sessionFactory.openSession().createSQLQuery("DELETE FROM Coach WHERE id = :id");
		query.setLong("id", id);
		return (Long.valueOf(query.executeUpdate())!=null);
	}
	
	@Override
	@Transactional
	public List<Coach> clearStaff() {
		sessionFactory.openSession().createQuery("DELETE FROM Coach").executeUpdate();
        return Collections.emptyList();
	}

}

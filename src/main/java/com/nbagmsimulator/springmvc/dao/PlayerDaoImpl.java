package com.nbagmsimulator.springmvc.dao;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nbagmsimulator.springmvc.model.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao{
	
	@Autowired
    SessionFactory sessionFactory;

    @Autowired
    HibernateTemplate hibernateTemplate;

	@Override
	public Player findById(long id) {
		String hql = "FROM Player p WHERE p.id = :id"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("id", id);
		return (Player) query.uniqueResult();
	}

	@Override
	public Player findByName(String name) {
		String hql = "FROM Player p WHERE p.name = :name"; // HQL Query
		Query query = sessionFactory.openSession().createQuery(hql);
		query.setParameter("name", name);
		return (Player) query.uniqueResult();
	}

	@Override
	@Transactional
	public Player signNewPlayer(Player player) {
		hibernateTemplate.save(player);
		return player;
	}

	@Override
	@Transactional
	public Player signExistingPlayer(Player player) {
		Player resultingPlayer = hibernateTemplate.load(Player.class, player.getId());
		resultingPlayer.setId(player.getId());
        resultingPlayer.setName(player.getName());
        resultingPlayer.setPosition(player.getPosition());
        resultingPlayer.setTeam(player.getTeam());
        resultingPlayer.setAge(player.getAge());
        resultingPlayer.setContractLength(player.getContractLength());
        resultingPlayer.setSalary(player.getSalary());
        resultingPlayer.setStats(player.getStats());
        hibernateTemplate.update(resultingPlayer);
        return resultingPlayer;
	}

	@Override
	@Transactional
	public long releasePlayer(long id) {
		Player resultingPlayer = hibernateTemplate.load(Player.class, id);
        resultingPlayer.setTeam(null);
        resultingPlayer.setContractLength(null);
        resultingPlayer.setSalary(null);
        hibernateTemplate.update(resultingPlayer);
        return id;
	}

	@Override
	@Transactional
	public long deletePlayerById(long id) {
		Query query = sessionFactory.openSession().createSQLQuery("DELETE FROM Player WHERE id = :id");
		query.setLong("id", id);
		return (Long.valueOf(query.executeUpdate()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAllPlayers() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Player.class); // Criteria Query
		return (List<Player>) criteria.list();
	}

	@Override
	public List<Player> clearRoster() {
		sessionFactory.openSession().createQuery("DELETE FROM Player").executeUpdate();
        return Collections.emptyList();
	}

	@Override
	public boolean isPlayerExist(Player player) {
		Query query = sessionFactory.openSession().createQuery("FROM Player p WHERE p.name = :name");
    	query.setString("name", player.getName());
    	List<?> pList = query.list();
    	if (pList.isEmpty()) {
    		return false;
    	}
    	return true;
	}

}

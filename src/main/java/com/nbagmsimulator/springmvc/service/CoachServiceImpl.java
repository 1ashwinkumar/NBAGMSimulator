package com.nbagmsimulator.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbagmsimulator.springmvc.dao.CoachDao;
import com.nbagmsimulator.springmvc.model.Coach;

@Service
public class CoachServiceImpl implements CoachService{

	@Autowired
	private CoachDao coachDao;

	@Override
	public Coach findById(Long id) {
		return coachDao.findById(id);
	}

	@Override
	public Coach findByName(String name) {
		return coachDao.findByName(name);
	}
	
	@Override
	@Transactional
	public Coach hireCoach(Coach coach) {
		if(!isCoachExist(coach) || coach.getTeam()==null) {
			if(!isCoachExist(coach)) {
				return coachDao.hireNewCoach(coach);
			}
			else {
				return coachDao.hireExistingCoach(coach);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public Coach fireCoach(Long id) {
		return coachDao.fireCoach(id);
	}

	@Override
	public List<Coach> getAllCoaches() {
		return coachDao.getAllCoaches();
	}

	@Override
	public List<Coach> clearStaff() {
		return coachDao.clearStaff();
	}

	@Override
	public boolean isCoachExist(Coach coach) {
		return coachDao.isCoachExist(coach);
	}

	@Override
	public Coach getHeadCoach() {
		return coachDao.getHeadCoach();
	}

	@Override
	@Transactional
	public boolean deleteCoach(Long id) {
		return coachDao.deleteCoachById(id);
	}

}

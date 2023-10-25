package com.nbagmsimulator.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nbagmsimulator.springmvc.model.Coach;

@Service
public class CoachServiceImpl implements CoachService{

	private static final AtomicLong counter = new AtomicLong();

	private static List<Coach> coaches;

	static{
		coaches=populateDummyCoaches();
	}

	@Override
	public Coach findById(long id) {
		for(Coach coach: coaches)
			if(coach.getId() == id)
				return coach;
		return null;
	}

	@Override
	public Coach findByName(String name) {
		for(Coach coach: coaches)
			if(coach.getName() == name)
				return coach;
		return null;
	}
	@Override
	public Coach hireCoach(Coach coach) {
		if(!isCoachExist(coach) || coach.getTeam()==null) {
			coach.setId(counter.incrementAndGet());
			coaches.add(coach);
			return coach;
		}
		return null;
	}

	@Override
	public Coach fireCoach(long id) {
		if(findById(id)!=null) {
			Coach temp=findById(id);
			coaches.remove(temp);
			temp.setTeam(null);
			coaches.add(temp);
			return temp;
		}
		return null;
	}

	@Override
	public List<Coach> getAllCoaches() {
		return coaches;
	}

	@Override
	public List<Coach> clearStaff() {
		coaches.clear();
		return coaches;
	}

	@Override
	public boolean isCoachExist(Coach coach) {
		return findByName(coach.getName())!=null;
	}

	@Override
	public Coach getHeadCoach() {
		for(Coach coach: coaches)
			if(coach.getIsHeadCoach())
				return coach;
		return null;
	}

	private static List<Coach> populateDummyCoaches(){
		List<Coach> values = new ArrayList<Coach>();
		values.add(new Coach(counter.incrementAndGet(), "Monte Williams", true, "Suns", 75, 80, 3, 30));
		values.add(new Coach(counter.incrementAndGet(), "Sam Cassell", false, "76ers", 70, 72, 4, 18));
		values.add(new Coach(counter.incrementAndGet(), "Stu Jackson", false, "Grizzlies", 61, 71, 2, 7));
		return values;
	}

}

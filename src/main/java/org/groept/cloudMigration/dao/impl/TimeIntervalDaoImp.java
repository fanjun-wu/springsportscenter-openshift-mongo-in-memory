package org.groept.cloudMigration.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.TimeIntervalDao;
import org.groept.cloudMigration.model.TimeInterval;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TimeIntervalDaoImp implements TimeIntervalDao{

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TimeInterval arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends TimeInterval> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<TimeInterval> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<TimeInterval> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeInterval findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TimeInterval> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TimeInterval> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeInterval findById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

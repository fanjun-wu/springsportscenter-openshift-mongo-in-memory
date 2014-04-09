package org.groept.cloudMigration.dao.impl;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.model.Court;
import org.springframework.stereotype.Repository;

@Repository
public class CourtDaoImp implements CourtDao {

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
	public void delete(Court arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Court> arg0) {
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
	public Iterable<Court> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Court> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Court findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Court> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Court> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Court findById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Court findByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

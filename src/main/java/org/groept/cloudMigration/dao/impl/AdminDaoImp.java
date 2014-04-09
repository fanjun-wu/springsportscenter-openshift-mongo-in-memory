package org.groept.cloudMigration.dao.impl;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.AdminDao;
import org.groept.cloudMigration.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImp implements AdminDao {

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
	public void delete(Admin arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Admin> arg0) {
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
	public Iterable<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Admin> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}

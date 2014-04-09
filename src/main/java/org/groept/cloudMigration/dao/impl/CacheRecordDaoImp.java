package org.groept.cloudMigration.dao.impl;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.CacheRecordDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.springframework.stereotype.Repository;

@Repository
public class CacheRecordDaoImp implements CacheRecordDao {

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
	public void delete(CacheRecord arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CacheRecord> arg0) {
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
	public Iterable<CacheRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CacheRecord> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheRecord findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CacheRecord> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CacheRecord> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheRecord findById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

}

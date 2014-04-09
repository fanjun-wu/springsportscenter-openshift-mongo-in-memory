package org.groept.cloudMigration.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.dao.CacheRecordDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.service.CacheRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CacheRecordServiceImpl implements CacheRecordService {

	@Autowired
	private CacheRecordDao cacheRecordDao;
	
	
	@Override
	public void saveCacheRecord(CacheRecord cacheRecord) {
		// TODO Auto-generated method stub
		
		cacheRecordDao.save(cacheRecord);

	}

	@Override
	public void deleteCacheRecord(ObjectId cacheRecordId) {
		// TODO Auto-generated method stub
		
		cacheRecordDao.delete(cacheRecordDao.findById(cacheRecordId));

	}

	@Override
	public CacheRecord getCacheRecord(ObjectId CacheRecordId) {
		// TODO Auto-generated method stub
		
		return cacheRecordDao.findById(CacheRecordId);
				
	}

	@Override
	public List getCacheRecords() {
		// TODO Auto-generated method stub
		return (List)cacheRecordDao.findAll();
	}

}

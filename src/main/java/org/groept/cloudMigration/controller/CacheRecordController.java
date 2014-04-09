package org.groept.cloudMigration.controller;

import java.util.List;
import java.util.Set;

import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.service.CacheRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CacheRecordController {
	
	private static final Logger logger = LoggerFactory.getLogger(CacheRecordController.class);
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	
	@RequestMapping(value="/getCacheMap", method=RequestMethod.GET)
	public @ResponseBody  List<CacheRecord> cacheMap() {
		logger.info("cache map!");
				
		//System.out.println("cache map size: "+cacheRecordService.getCacheRecords().size());
		
		return (List)cacheRecordService.getCacheRecords();
				
	}
	
	
	@RequestMapping(value="/cacheMap", method=RequestMethod.GET)
	public String getCacheMapPage()
	{
		
		return "frontend/cache-map";
		
	}
	
	
	
	

}

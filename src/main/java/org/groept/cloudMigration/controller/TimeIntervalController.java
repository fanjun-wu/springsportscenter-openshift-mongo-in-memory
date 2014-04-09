package org.groept.cloudMigration.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimeIntervalController {
private static final Logger logger = LoggerFactory.getLogger(TimeIntervalController.class);
	
	private TimeIntervalService timeIntervalService;
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	
	@RequestMapping(value="/timeIntervalList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing timeIntervals.");
		
		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
		
		
		Collection<TimeInterval> timeIntervals = timeIntervalService.getTimeIntervals();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("timeIntervals", timeIntervals);
		return new ModelAndView("timeInterval/timeIntervalList", model);
	}
	
	
	
	
	

	@RequestMapping(value="/getTimeInterval", method=RequestMethod.GET)
	public ModelAndView fetchTimeInterval(@RequestParam("timeIntervalId") String timeIntervalId) {
		logger.info("Fetching timeInterval " + timeIntervalId);
		TimeInterval timeInterval = timeIntervalService.getTimeInterval(timeIntervalId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("timeInterval", timeInterval);
		return new ModelAndView("timeInterval/modifyTimeInterval", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteTimeInterval", method=RequestMethod.GET)
	public String deleteTimeInterval(@RequestParam("timeIntervalId") String timeIntervalId) {
		logger.info("Deleting timeInterval " + timeIntervalId);
		timeIntervalService.deleteTimeInterval(timeIntervalId);
		return "redirect:timeIntervalList";
	}
	
	
	
	@RequestMapping(value="/newTimeInterval", method=RequestMethod.GET)
	public ModelAndView newTimeInterval() {
		logger.info("Create new timeInterval instance");
		TimeInterval timeInterval = new TimeInterval();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("timeInterval", timeInterval);
		return new ModelAndView("timeInterval/newTimeInterval", model);
	}
	
	
	
	@RequestMapping(value="/saveTimeInterval", method=RequestMethod.POST)
	public String createTimeInterval(@ModelAttribute("timeInterval") TimeInterval timeInterval,
			BindingResult result, Model model) {
		logger.info("Save timeInterval instance");
		timeIntervalService.saveTimeInterval(timeInterval);
		return "redirect:timeIntervalList";
	}
	
	@RequestMapping(value="/updateTimeInterval", method=RequestMethod.POST)
	public String updateTimeInterval(@ModelAttribute("timeInterval") TimeInterval timeInterval,
			BindingResult result, Model model) {
		logger.info("Save timeInterval instance");
		timeIntervalService.editTimeInterval(timeInterval);
		return "redirect:timeIntervalList";
	}
	
	

	
	@Autowired
	public void setTimeIntervalService(TimeIntervalService timeIntervalService) {
		this.timeIntervalService = timeIntervalService;
	}
	
}

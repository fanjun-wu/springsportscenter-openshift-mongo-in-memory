package org.groept.cloudMigration.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CourtService;
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
public class CourtController {

private static final Logger logger = LoggerFactory.getLogger(CourtController.class);
	
	private CourtService courtService;
	
	@Autowired
	private CacheRecordService cacheRecordService; 

	
	@RequestMapping(value="/courtList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing courts.");
		
		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
		
		
		Collection<Court> courts = courtService.getCourts();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("courts", courts);
		return new ModelAndView("court/courtList", model);
	}
	
	
	
	
	

	@RequestMapping(value="/getCourt", method=RequestMethod.GET)
	public ModelAndView fetchCourt(@RequestParam("courtId") String courtId) {
		logger.info("Fetching court " + courtId);
		Court court = courtService.getCourt(courtId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("court", court);
		return new ModelAndView("court/modifyCourt", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteCourt", method=RequestMethod.GET)
	public String deleteCourt(@RequestParam("courtId") String courtId) {
		logger.info("Deleting court " + courtId);
		courtService.deleteCourt(courtId);
		return "redirect:courtList";
	}
	
	
	
	@RequestMapping(value="/newCourt", method=RequestMethod.GET)
	public ModelAndView newCourt() {
		logger.info("Create new court instance");
		Court court = new Court();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("court", court);
		return new ModelAndView("court/newCourt", model);
	}
	
	
	
	@RequestMapping(value="/saveCourt", method=RequestMethod.POST)
	public String createCourt(@ModelAttribute("court") Court court,
			BindingResult result, Model model) {
		logger.info("Save court instance");
		courtService.saveCourt(court);
		return "redirect:courtList";
	}
	
	@RequestMapping(value="/updateCourt", method=RequestMethod.POST)
	public String updateCourt(@ModelAttribute("court") Court court,
			BindingResult result, Model model) {
		logger.info("Save court instance");
		courtService.editCourt(court);
		return "redirect:courtList";
	}
	
	

	
	@Autowired
	public void setCourtService(CourtService courtService) {
		this.courtService = courtService;
	}
}

package org.groept.cloudMigration.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CourtService;
import org.groept.cloudMigration.service.HallService;
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
public class HallController  {
	
private static final Logger logger = LoggerFactory.getLogger(HallController.class);
	@Autowired
	private HallService hallService;
	@Autowired
	private CourtService courtService;
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	
	@RequestMapping(value="/hallList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing halls.");
		
		System.out.println("getting hall list");
		
		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
				
		List<Hall> halls = hallService.getHalls();
		//Collection<Hall> halls=null;
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("halls", halls);
		return new ModelAndView("hall/hallList", model);
	}
	
	
	@RequestMapping(value="/showhallCourtList", method=RequestMethod.GET)
	public ModelAndView listofCourt(@RequestParam("hallId") String hallId) {
		logger.info("Listing courts.");
		Collection<Court> courts = hallService.listofCourts(hallId);
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("courts", courts);
		return new ModelAndView("hall/showhallCourtList", model);
	}
	
	
	
	

	@RequestMapping(value="/getHall", method=RequestMethod.GET)
	public ModelAndView fetchHall(@RequestParam("hallId") String hallId) {
		logger.info("Fetching hall " + hallId);
		Hall hall = hallService.getHall(hallId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("hall", hall);
		return new ModelAndView("hall/modifyHall", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteHall", method=RequestMethod.GET)
	public String deleteHall(@RequestParam("hallId") String hallId) {
		logger.info("Deleting hall " + hallId);
		hallService.deleteHall(hallId);
		return "redirect:hallList";
	}
	
	@RequestMapping(value="/hallCourtList", method=RequestMethod.GET)
	public ModelAndView HalladdCourt(@RequestParam("hallId") String hallId) {
		logger.info("Add court for hall " + hallId);
		Hall hall = hallService.getHall(hallId);
		Collection<Court> courts = courtService.getCourts();
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("hall", hall);
		modelAndView.put("courts", courts);
		return new ModelAndView("hall/addCourt", modelAndView);
	}
	
	@RequestMapping(value="/hallAddCourt", method=RequestMethod.GET)
	public String hallAddCourt(@RequestParam("hallId") String hallId,@RequestParam("courtId") String courtId) {
		logger.info("Add hall to court " + hallId);
		hallService.addCourt(hallId, courtId);
		
		System.out.println("OK");
		return "redirect:hallList";
	}
	
	
	
	@RequestMapping(value="/newHall", method=RequestMethod.GET)
	public ModelAndView newHall() {
		logger.info("Create new hall instance");
		Hall hall = new Hall();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("hall", hall);
		return new ModelAndView("hall/newHall", model);
	}
	
	
	
	@RequestMapping(value="/saveHall", method=RequestMethod.POST)
	public String createHall(@ModelAttribute("hall") Hall hall,
			BindingResult result, Model model) {
		logger.info("Save hall instance");
		hallService.saveHall(hall);
		return "redirect:hallList";
	}
	
	@RequestMapping(value="/updateHall", method=RequestMethod.POST)
	public String updateHall(@ModelAttribute("hall") Hall hall,
			BindingResult result, Model model) {
		logger.info("Save hall instance");
		hallService.editHall(hall);
		return "redirect:hallList";
	}
	
	

	
	
}

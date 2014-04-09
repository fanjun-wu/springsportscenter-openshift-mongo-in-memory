package org.groept.cloudMigration.controller;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CapabilityService;
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
public class CapabilityController {

	
	private static final Logger logger = LoggerFactory.getLogger(CapabilityController.class);

	private CapabilityService capabilityService;
	
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	

	@RequestMapping(value="/capabilityList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing capabilities.");		
		
		System.out.println("controller capability list()");
		
		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);		
				
		Collection<Capability> capabilities = capabilityService.getCapabilities();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("capabilities", capabilities);
		return new ModelAndView("capability/capabilityList", model);
	}
	
	
	
	
	@RequestMapping(value="/getCapability", method=RequestMethod.GET)
	public ModelAndView fetchCapability(@RequestParam("capabilityId") String capabilityId) {
		logger.info("Fetching capability " + capabilityId);
		Capability capability = capabilityService.getCapability(capabilityId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("capability", capability);
		return new ModelAndView("capability/modifyCapability", modelAndView);
	}
	
	
	
	@RequestMapping(value="/deleteCapability", method=RequestMethod.GET)
	public String deleteCapability(@RequestParam("capabilityId") String capabilityId) {
		logger.info("Deleting capability " + capabilityId);
		capabilityService.deleteCapability(capabilityId);
		return "redirect:capabilityList";
	}
	
	
	
	@RequestMapping(value="/newCapability", method=RequestMethod.GET)
	public ModelAndView newCapability() {
		logger.info("Create new capability instance");
		Capability capability = new Capability();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("capability", capability);
		return new ModelAndView("capability/newCapability", model);
	}
	
	
	@RequestMapping(value="/saveCapability", method=RequestMethod.POST)
	public String createCapability(@ModelAttribute("capability") Capability capability,
			BindingResult result, Model model) {
		logger.info("Save capability instance");
		capabilityService.saveCapability(capability);
		return "redirect:capabilityList";
	}

	@RequestMapping(value="/updateCapability", method=RequestMethod.POST)
	public String updateCapability(@ModelAttribute("capability") Capability capability,
			BindingResult result, Model model) {
		logger.info("Save Capability instance");
		capabilityService.editCapability(capability);
		return "redirect:capabilityList";
	}
	
	@Autowired
	public void setCapabilityService(CapabilityService capabilityService) {
		this.capabilityService = capabilityService;
	}
	
}

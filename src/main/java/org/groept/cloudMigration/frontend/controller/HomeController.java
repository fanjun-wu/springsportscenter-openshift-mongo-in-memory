package org.groept.cloudMigration.frontend.controller;

import java.util.List;

import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.service.AdminService;
import org.groept.cloudMigration.service.CapabilityService;
import org.groept.cloudMigration.service.CourtService;
import org.groept.cloudMigration.service.HallService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private CapabilityService capabilityService;
	private TimeIntervalService timeIntervalService;
	private AdminService adminService;
	private CourtService courtService;
	private HallService hallService;
	private ReservationService reservationService;
	private SubscriberService subscriberService;
	
	
	@RequestMapping(value={"/reservation","/reservation/"},method=RequestMethod.GET)
	public String getReservationPage()
	{
		
		return "frontend/reservation";
	}
	
	
	@RequestMapping(value={"/success","/success/"},method=RequestMethod.GET)
	public String getSuccessPage()
	{
		
		return "frontend/success";
	}
	

	@RequestMapping(value={"/myhome","/"," "},method=RequestMethod.GET)
	public String getHomePage()
	{
		
		return "frontend/home";
	}
/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("home");
		return model;

	}
*/	

	@RequestMapping(value = {"/about","/about/"}, method = RequestMethod.GET)
	public String getAboutPage(Model model) {
		logger.info("About page !");
		
		return "frontend/about";
	}
	
	/*
	@RequestMapping(value = "/login/user-name/{userName}/user-authen-key/{userAuthenKey}", method = RequestMethod.GET)
	public String getUserPage(@PathVariable String userName,@PathVariable String userAuthenKey) {
		logger.info("About page !");
		Subscriber subscriber=new Subscriber();
		List<Subscriber> subs=subscriberService.getSubscribers();
		for(Subscriber sub:subs)
			
			if(sub.getAuthenKey().equals(userAuthenKey)&&sub.getName().equals(userName))
			{
				subscriber=sub;
				
				return "frontend/cancel-reservation";
			}
		
		return "frontend/not-found";
	}
	
	*/
	@RequestMapping(value = "/login/user-name/{userName}/user-authen-key/{userAuthenKey}", method = RequestMethod.GET)
	public ModelAndView getUserPage(@PathVariable String userName,@PathVariable String userAuthenKey) {
		logger.info("About page !");
		ModelAndView mav = new ModelAndView();
		for(Subscriber sub:(List<Subscriber>)subscriberService.getSubscribers())
			
			if(sub.getAuthenKey().equals(userAuthenKey)&&sub.getName().equals(userName))
			{
				System.out.println("we find you: "+userName);
				mav.addObject("subscriber",sub);
				mav.setViewName("frontend/cancel-reservation");
				return mav;
				
			}
		
		mav.setViewName("frontend/not-found");
		
		return mav;
	}
	
	
	
	
	
	
	

	@Autowired
	public void setCapabilityService(CapabilityService capabilityService) {
		this.capabilityService = capabilityService;
	}
	@Autowired
	public void setTimeIntervalService(TimeIntervalService timeIntervalService) {
		this.timeIntervalService = timeIntervalService;
	}
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	@Autowired
	public void setCourtService(CourtService courtService) {
		this.courtService = courtService;
	}
	@Autowired
	public void setHallService(HallService hallService) {
		this.hallService = hallService;
	}
	@Autowired
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	@Autowired
	public void setSubscriberService(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}
	
	
}

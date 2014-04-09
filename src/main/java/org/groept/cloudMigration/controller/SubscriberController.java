package org.groept.cloudMigration.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
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
public class SubscriberController {

private static final Logger logger = LoggerFactory.getLogger(SubscriberController.class);
	@Autowired
	private SubscriberService subscriberService;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private CacheRecordService cacheRecordService; 
	
	

	
	
	@RequestMapping(value="/subscriberList", method=RequestMethod.GET)
	public ModelAndView list() {
		logger.info("Listing subscribers.");
		
		CacheRecord cacheRecord=new CacheRecord(1,0,new java.util.Date());
		cacheRecordService.saveCacheRecord(cacheRecord);
		
		
		Collection<Subscriber> subscribers = subscriberService.getSubscribers();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("subscribers", subscribers);
		return new ModelAndView("subscriber/subscriberList", model);
	}
	
	
	
	
	

	@RequestMapping(value="/getSubscriber", method=RequestMethod.GET)
	public ModelAndView fetchSubscriber(@RequestParam("subscriberId") String subscriberId) {
		logger.info("Fetching subscriber " + subscriberId);
		Subscriber subscriber = subscriberService.getSubscriber(subscriberId);
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("subscriber", subscriber);
		return new ModelAndView("subscriber/modifySubscriber", modelAndView);
	}
	
	
	@RequestMapping(value="/deleteSubscriber", method=RequestMethod.GET)
	public String deleteSubscriber(@RequestParam("subscriberId") String subscriberId) {
		logger.info("Deleting subscriber " + subscriberId);
		subscriberService.deleteSubscriber(subscriberId);
		return "redirect:subscriberList";
	}
	
	
	
	@RequestMapping(value="/newSubscriber", method=RequestMethod.GET)
	public ModelAndView newSubscriber() {
		logger.info("Create new subscriber instance");
		Subscriber subscriber = new Subscriber();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("subscriber", subscriber);
		return new ModelAndView("subscriber/newSubscriber", model);
	}
	
	
	
	@RequestMapping(value="/saveSubscriber", method=RequestMethod.POST)
	public String createSubscriber(@ModelAttribute("subscriber") Subscriber subscriber,
			BindingResult result, Model model) {
		logger.info("Save subscriber instance");
		subscriberService.saveSubscriber(subscriber);
		return "redirect:subscriberList";
	}
	
	@RequestMapping(value="/updateSubscriber", method=RequestMethod.POST)
	public String updateSubscriber(@ModelAttribute("subscriber") Subscriber subscriber,
			BindingResult result, Model model) {
		logger.info("Save subscriber instance");
		subscriberService.editSubscriber(subscriber);
		return "redirect:subscriberList";
	}
	
	
	@RequestMapping(value="/showReservationList", method=RequestMethod.GET)
	public ModelAndView HalladdCourt(@RequestParam("subscriberId") String subscriberId) {
		
		Subscriber subscriber=subscriberService.getSubscriber(subscriberId);
		Collection<Reservation> reservations = reservationService.getReservations();
		Map<String,Object>modelAndView = new HashMap<String,Object>();
		modelAndView.put("subscriber", subscriber);
		modelAndView.put("reservations", reservations);
		return new ModelAndView("subscriber/showReservationList", modelAndView);
	}
	
	
	
	
	@RequestMapping(value="/newReservationforPerson", method=RequestMethod.GET)
	public ModelAndView newReservation(@RequestParam("subscriberId") String subscriberId) {
		Subscriber subscriber=subscriberService.getSubscriber(subscriberId);
		Reservation reservation = new Reservation();
		Map<String,Object>model = new HashMap<String,Object>();
		model.put("subscriber", subscriber);
		model.put("reservation", reservation);
		return new ModelAndView("subscriber/newReservationforPerson", model);
	}
	
	
	//@RequestParam("reservationId") String reservationId,
	
	@RequestMapping(value="/addReservationforPerson", method=RequestMethod.POST)
	public String createReservation(@RequestParam("subscriberId") String subscriberId, @ModelAttribute("reservation") Reservation reservation,
			 BindingResult result, Model model) {
		
		reservationService.saveReservation(reservation);
		System.out.println("hehe"+subscriberId);
		System.out.println(reservation.getId());
		
		
		subscriberService.addReservationtoPerson(subscriberId, reservation);
		
		
		return "redirect:subscriberList";
	}
	
	
}

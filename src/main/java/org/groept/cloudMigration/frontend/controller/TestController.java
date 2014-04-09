package org.groept.cloudMigration.frontend.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.model.TimeInterval;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fanjun")
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	private CapabilityService capabilityService;
	private TimeIntervalService timeIntervalService;
	private AdminService adminService;
	private CourtService courtService;
	private HallService hallService;
	private ReservationService reservationService;
	private SubscriberService subscriberService;
	
	

	TestController() {
		
	}
	
	@RequestMapping(value="/testperson", method=RequestMethod.GET)
	public void simpletest4() {
	
		Admin admin=new Admin(UUID.randomUUID().toString(),"backstraat","backstraat@gmail.com","0444444444","M",23,"admin");
		
		adminService.saveAdmin(admin);
		
		
		Subscriber s1=new Subscriber(UUID.randomUUID().toString(),"vaarstraat1","vaarstraat1@gmail.com","02222222222","M",23,"dsqdq484sdqsdsq");
		
		subscriberService.saveSubscriber(s1);  
	
	}
	
	
	
	@RequestMapping(value="/testsmall", method=RequestMethod.GET)
	public void simpletest3() {
		
		Capability BK=new Capability(UUID.randomUUID().toString(),"Basketball","good","no");
		Capability BD=new Capability(UUID.randomUUID().toString(),"Badminton","good","no");
		
		capabilityService.saveCapability(BD);
		capabilityService.saveCapability(BK);
		
		
		Court B1=new Court(UUID.randomUUID().toString(),"B1","no");
		courtService.saveCourt(B1);
		
		Set<Court> court001=new HashSet<Court>();
		court001.add(B1);
		BD.setCourt(court001);
		capabilityService.saveCapability(BD);
		
		Court B2=new Court(UUID.randomUUID().toString(),"B2","no");
		courtService.saveCourt(B2);
		Set<Court> court002=new HashSet<Court>();
		court002.add(B2);
		BK.setCourt(court002);
		capabilityService.saveCapability(BK);

		Admin admin=new Admin(UUID.randomUUID().toString(),"conna","conna@gmail.com","0483359884","M",23,"admin");
		
		adminService.saveAdmin(admin);
		
		Hall hall=new Hall(UUID.randomUUID().toString(),"HALL1",8,14,"no");
				
		List<Court> courtSet=new ArrayList<Court>();
		courtSet.add(B2);
		courtSet.add(B1);		
		
		hall.setCourts(courtSet);
		hall.setAdmin(admin);
		hallService.saveHall(hall);
		
	
		Set<Capability> capBD=new HashSet<Capability>();
		Set<Capability> capBK=new HashSet<Capability>();
		capBD.add(BD);
		capBD.add(BK);
		
		
		
		///////////////////////////////////////////////////////////////////
		
		Subscriber s1=new Subscriber(UUID.randomUUID().toString(),"lihua1","lihua1@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		Subscriber s2=new Subscriber(UUID.randomUUID().toString(),"lihua2","lihua2@gmail.com","0254846854","M",23,"dsqdq484sdqsdsq");
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		
		
		TimeInterval t1=new TimeInterval(UUID.randomUUID().toString(),9,getDateByString("2014-3-20"));
		TimeInterval t2=new TimeInterval(UUID.randomUUID().toString(),9,getDateByString("2014-3-20"));
		TimeInterval t3=new TimeInterval(UUID.randomUUID().toString(),10,getDateByString("2014-3-20"));
		
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		
						
		Set<TimeInterval> timeIntervals1=new HashSet<TimeInterval>();
		timeIntervals1.add(t1);
		Set<TimeInterval> timeIntervals2=new HashSet<TimeInterval>();
		timeIntervals2.add(t2);
		Set<TimeInterval> timeIntervals3=new HashSet<TimeInterval>();
		timeIntervals3.add(t3);
		
		Reservation r1=new Reservation(UUID.randomUUID().toString(),"book basket","no");
		Reservation r2=new Reservation(UUID.randomUUID().toString(),"book basket","no");

		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		
		/*
		for(Court c:courtSet)
		{
			
			Set<Reservation> basketReser=new HashSet<Reservation>();
			Set<Reservation> badminReser=new HashSet<Reservation>();
			Set<Reservation> tennisReser=new HashSet<Reservation>();
			//List<Reservation> pingpongReser=new ArrayList<Reservation>();			
			Set<Capability> cpty=new HashSet<Capability>();
			for(Capability cp:(List<Capability>)capabilityService.getCapabilities())
			{
				if(cp.getCourt().contains(c))
					cpty.add(cp);
			}
			
			//for(Capability cap:c.getCapability())
			for(Capability cap:cpty)
			{	
			if(cap.getResource().equalsIgnoreCase("basketball"))
			{
				r1.setCourt(c);
				r2.setCourt(c);
				
				basketReser.add(r1);
				basketReser.add(r2);
				//c.setReservation(basketReser);
				//c.addReservation(r1);
				//c.addReservation(r2);
								
				reservationService.saveReservation(r1); 
				reservationService.saveReservation(r2); 
				 
				courtService.saveCourt(c);
				
			}
			
			
		}
		}
		*/
		
		
		r1.setCourt(B1);
		
		r1.setSubscriber(s1);		
		r1.addTimeInterval(t1);
		
		r2.setCourt(B2);		
		r2.setSubscriber(s2);		
		r2.addTimeInterval(t2);
				
		
		//save Reservation, TimeInterval, Court, Subscriber in relationtimeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t1);
		timeIntervalService.saveTimeInterval(t2);
		timeIntervalService.saveTimeInterval(t3);
		
		subscriberService.saveSubscriber(s1);  
		subscriberService.saveSubscriber(s2);  
		
		reservationService.saveReservation(r1); 
		reservationService.saveReservation(r2); 
		
		
		/*
		reservationService.saveReservation(r3); 
		reservationService.saveReservation(r4); 
		reservationService.saveReservation(r5); 
	*/
		
		
		
	
	
	}
	

	
	
	public Date getDateByString(String dateString)
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
		
		Date date=new Date();
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;		
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
package org.groept.cloudMigration.frontend.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	private CapabilityService capabilityService;
	private TimeIntervalService timeIntervalService;
	private AdminService adminService;
	private CourtService courtService;
	private HallService hallService;
	private ReservationService reservationService;
	private SubscriberService subscriberService;
	
	private Capability _capability=new Capability();
	private List<TimeInterval> _timeIntervals = new ArrayList<TimeInterval>();
	
	private Set<Hall> _hallsAvailable = new HashSet<Hall>();
	private Set<Court> _allCourtsThisCap = new HashSet<Court>();
	private Set<Court> _courtsAvailable= new HashSet<Court>();
	private Set<Reservation> _reservations=new HashSet<Reservation>();
	
	private Set<Integer> _startTimeSetAvailable=new HashSet<Integer>();
	private Date dateSelected=null; 
	private String _startTimeRecieved=null;	
	private Subscriber _subscriber=new Subscriber();
	
	
	private String _nameOfHallRecieved=null;
	private String _nameOfCourtRecieved=null;
	
	private int testingIntegerFlag=0;
	
	//===================================================================================
	//===================================================================================
	//in /getCapabilities  GET ----> none variables calculated
	//in /getCapabilities  POST ----> _capability,_allCourtsThisCap
	//in /getDate POST  ----> dateSelected, _timeIntervals, _reservations
	//in /getTimeIntervals GET--->  _startTimeSetAvailable
	//in /getTimeIntervals POST--->  _startTimeRecieved
	//in /getHalls GET ---> _hallsAvailable
	//in /getHalls POST ---> _nameOfHallRecieved
	//in /getCourts GET ---> _courtsAvailable
	//in /getCourts POST ---> _nameOfCourtRecieved
	//in /getUserInfo  POST---> _subscriber
	//===================================================================================
	//===================================================================================
	

	MainController() {
		
	}



	@RequestMapping(value = "/getCapabilities", method = RequestMethod.GET)
	public @ResponseBody
	List<Capability> getCapabilities() {

		List<Capability> capabilitiesTemp = capabilityService.getCapabilities();
		
		List<Capability> capabilities=new ArrayList<Capability>();
		
		for(Capability cap:capabilitiesTemp)
		{
			//didn't show the court info, because if yes, there is an json .... error in this case????  
			capabilities.add(new Capability(cap.getId(),cap.getResource(),cap.getConditionCap(),cap.getDiscriptionCap()));
			
		}		
		System.out.println("capability types: "+capabilities.toString());
		
		return capabilities;
				
	}

	
	@RequestMapping(value = "/getCapabilities", method = RequestMethod.POST)
	public @ResponseBody
	void getCapabilitySelected(@RequestBody String capability) {

		System.out.println("inside //getCapabilities  POST");
		System.out.println("Capability recieved: "+capability);
		
		for(int i=0;i<capabilityService.getCapabilities().size();i++)
		{
			Capability cap=(Capability)capabilityService.getCapabilities().get(i);
			
			System.out.println("capability: "+cap.getResource()+", court size: "+cap.getCourt().size());
			
			
			if(cap.getResource().equalsIgnoreCase(capability))
				_capability=cap;	
			System.out.println("+++"+_capability.getResource());
		}
		
		
		
		
		
		//get all the courts can be used for this sport
		_allCourtsThisCap=_capability.getCourt();	
		System.out.println("ok here");
		//System.out.println(_capability.getCourt().size());
		System.out.println("size of courts for this sport: "+_allCourtsThisCap.size());
		
		cleanVariablesAfterSelectSports();
	}
	
	
	@RequestMapping(value="/getDate", method=RequestMethod.POST)
	public @ResponseBody void getDateSelected(@RequestBody String dateRecieved)
	{		

		System.out.println("inside /getDate  POST");
		System.out.println("Date recieved: "+dateRecieved);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			dateSelected = formatter.parse(dateRecieved);
		
			System.out.println("Date recieved after parse: "+dateSelected);
			_timeIntervals=timeIntervalService.getTimeIntervalByDate(dateSelected);		
			
			//get all the reservations for this date
			if(_timeIntervals.size()!=0)
				for(TimeInterval tt:_timeIntervals)
				{
					
					
					//if(tt.getReservation().size()!=0)
					
					for(Reservation r:(List<Reservation>)reservationService.getReservations())
					{
						Set<String> timeSet=new HashSet<String>();
						for(TimeInterval t:r.getTimeInterval())
							timeSet.add(t.getId());
						//if(r.getTimeInterval().contains(tt))
						if(timeSet.contains(tt.getId()))
							_reservations.add(r);			
					}
						
						/*
						for(Reservation res:tt.getReservation())
						{
							_reservations.add(res);					
						}
						*/
					
					

				}			
			
			System.out.println(" "+_reservations.size()+" reservations this day already");
			
			
		//	System.out.println("TimeInterval(with same date) Size: "+_timeIntervals.size());
			
		//	System.out.println("Reservations size: "+_reservations.size()+" at "+dateRecieved);
			
			cleanVariablesAfterSelectDate();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//list whose element[start time] begins from open to close, and return the elements[start time] which are not inside theset of timeSetReserved
	public Set<Integer> timeSetLeft(int open,int close,Set<Integer> timeSetReserved)
	{		
		Set<Integer> timeSetStandard=new HashSet<Integer>();
		Set<Integer> timeSetLeft=new HashSet<Integer>();

		for(int i=open;i<close;i++)
			timeSetStandard.add(i);
		
		System.out.println("timeSetReserved size: "+timeSetReserved.size());
		
		for(Integer t:timeSetReserved)
			System.out.println(": "+t);
		
		if(timeSetReserved.size()!=0)
		{
			
			for(Integer itr:timeSetStandard)
			{
				if(!timeSetReserved.contains(itr))
					timeSetLeft.add(itr);
			}
			
		}
		else
			timeSetLeft=timeSetStandard;
		
		
		System.out.println("////timeSetStandard size: "+timeSetStandard.size());
		System.out.println("////timeSetLeft size: "+timeSetLeft.size());
		
		return timeSetLeft;
	}


	@RequestMapping(value = "/getTimeIntervals", method = RequestMethod.GET)
	public @ResponseBody
	Set<Integer> getTimeIntervals() {
		

		//get the start time list available for this sport at this day
		List< Set<Integer> > _startTimeSetLeftTotal=new ArrayList<Set<Integer>>();
		
		for(Court ct:_allCourtsThisCap)
		{
			Set<Integer> _startTimeSetReservedSingleCourt=new HashSet<Integer>();
			Set<Integer> _startTimeSetLeftSingleCourt=new HashSet<Integer>();				
			
			//get all the reservation for that court in that day and manipulate the start time Set			
			
			
			Set<Reservation> reservSet=new HashSet<Reservation>();
			for(Reservation r:(List<Reservation>)reservationService.getReservations())
			{										
				if(r.getCourt().getId().equals(ct.getId()))
					reservSet.add(r);
			}
				
			//System.out.println("ct getReservation() size(): "+ct.getReservation().size());
			System.out.println("ct getReservation() size(): "+reservSet.size());
			
			if(reservSet.size()!=0)
				for(Reservation res: reservSet)
				{

//					System.out.println("getTimeInterval() size: "+res.getTimeInterval().toString());
					for(TimeInterval tvl:res.getTimeInterval())
					{
						if( compareTwoDate(tvl.getDate(),dateSelected))
						{
							_startTimeSetReservedSingleCourt.add(tvl.getStartTime());
						}
							
					}									
				}

			System.out.println("_startTimeSetReservedSingleCourt size: "+_startTimeSetReservedSingleCourt.size());
			
			
			Hall tempHall=new Hall();
			
			System.out.println("court id: "+ct.getId());
			
			for(Hall h:(List<Hall>)hallService.getHalls())
			{
				
				Set<String> hallCourts=new HashSet<String>();
				for(Court c:h.getCourts())
					hallCourts.add(c.getId());
				if(hallCourts.contains(ct.getId()))
				{
					System.out.println("find the hall");
					tempHall=h;
				}
					
				
			}
			
			/////
			//???? open time and cloase time =0??????--->the hall is wrong???????
			////
			System.out.println(" open time: "+tempHall.getOpenTime()+", close time: "+tempHall.getCloseTime());
			
			//_startTimeSetLeftSingleCourt=timeSetLeft(ct.getHall().getOpenTime(),ct.getHall().getCloseTime(),_startTimeSetReservedSingleCourt);
			_startTimeSetLeftSingleCourt=timeSetLeft(tempHall.getOpenTime(),tempHall.getCloseTime(),_startTimeSetReservedSingleCourt);
			
			System.out.println("_startTimeSetLeftSingleCourt size: "+_startTimeSetLeftSingleCourt.size());
			
			_startTimeSetLeftTotal.add(_startTimeSetLeftSingleCourt);							
		}
		
		System.out.println("_startTimeSetLeftTotal size: "+_startTimeSetLeftTotal.size());
		
		for(Set<Integer> setElement:_startTimeSetLeftTotal )
			for(Integer element:setElement)
			{
				_startTimeSetAvailable.add(element);
				System.out.println("-->  "+element);
			}

		System.out.println("_startTimeSetAvailable size: "+_startTimeSetAvailable.size());
		
		return _startTimeSetAvailable; 
	}

	
	
	public boolean compareTwoDate(Date d1,Date d2)
	{
		if(d1.getYear()==d2.getYear()&&d1.getMonth()==d2.getMonth()&&d1.getDay()==d2.getDay())
			return true;
		else
			return false;
	}
	
	
	
	@RequestMapping(value = "/getTimeIntervals", method = RequestMethod.POST)
	public @ResponseBody
	void getTimeIntervalSelected(@RequestBody String interval) {
		
		_startTimeRecieved=interval;
		System.out.println("start time recieved: "+interval);
		
		cleanVariablesAfterSelectTimeInterval();
		
	}

	
	@RequestMapping(value = "/getHalls", method = RequestMethod.GET)
	public @ResponseBody
	Set<Hall> getHallAvailables() {
		//calculate the halls available
				for(Court ct:_allCourtsThisCap)
				{
					Set<Integer> startTimeReservedSingleCourt=new HashSet<Integer>();
					
					Set<Reservation> reservSet=new HashSet<Reservation>();
					for(Reservation r:(List<Reservation>)reservationService.getReservations())
					{
						if(r.getCourt().equals(ct))
							reservSet.add(r);
					}
					
					
					//for(Reservation res:ct.getReservation())
					for(Reservation res:reservSet)
					{
						for(TimeInterval tv:res.getTimeInterval())
						{							
							if(compareTwoDate(tv.getDate(),dateSelected))							
								startTimeReservedSingleCourt.add(tv.getStartTime());
							
						}
						
					}
					//if the start time user choose isn't in the set of start time set reserved, then add this court or hall as available
					if(!startTimeReservedSingleCourt.contains(Integer.parseInt(_startTimeRecieved)))
					{			
						
						Hall tempHall=new Hall();																
						
						for(Hall h:(List<Hall>)hallService.getHalls())
						{
							
							Set<String> hallCourts=new HashSet<String>();
							for(Court c:h.getCourts())
								hallCourts.add(c.getId());
							if(hallCourts.contains(ct.getId()))
							{
								System.out.println("find the hall");
								tempHall=h;
							}
																				
							
						}
						
						_hallsAvailable.add(tempHall);				
					}	
					
				}
				
				System.out.println("available halls size: "+_hallsAvailable.size());
				

				
		Set<Hall> hallTemp=new HashSet<Hall>();		
		for(Hall ha:_hallsAvailable)		
		{
			hallTemp.add(new Hall(ha.getId(),ha.getName(),ha.getOpenTime(),ha.getCloseTime(),ha.getIntroduction()));			
		}		

		//don't return _hallsAvailable directly, throw away the relations here, 
		//just the hall info is needed, if not, we will get the json serialize error
		return hallTemp;

	}
	
	
	@RequestMapping(value = "/getHalls", method = RequestMethod.POST)
	public @ResponseBody
	void getHallSelected(@RequestBody String hall) {

		_nameOfHallRecieved=hall;
		System.out.println("hall choosen: "+hall);
		
		cleanVariablesAfterSelectHall();
	}
	


	@RequestMapping(value = "/getCourts", method = RequestMethod.GET)
	public @ResponseBody
	Set<Court> getCourts() {

		
		Hall hallTemp=new Hall();
		for(Hall ha:_hallsAvailable)
		{
			if(ha.getName().equalsIgnoreCase(_nameOfHallRecieved))
			{
				hallTemp=ha;				
			}			
		}
		
		for(Court ct:hallTemp.getCourt())
		{
			Set<Integer> startTimeReservedSingleCourt=new HashSet<Integer>();
			
			Set<Capability> cpty=new HashSet<Capability>();
			for(Capability cp:(List<Capability>)capabilityService.getCapabilities())
			{
			
				Set<String> allCourts=new HashSet<String>();
				for(Court c:cp.getCourt())
					allCourts.add(c.getId());	
					
				//if(cp.getCourt().contains(ct))
					if(allCourts.contains(ct.getId()))
					cpty.add(cp);
			
			
			}
			
			
			Set<Reservation> reservSet=new HashSet<Reservation>();
			for(Reservation r:(List<Reservation>)reservationService.getReservations())
			{
				if(r.getCourt().equals(ct))
					reservSet.add(r);
			}
			
			
			//for(Capability cap:ct.getCapability())
			for(Capability cap:cpty)
				if(cap.getResource().equalsIgnoreCase(_capability.getResource()))
				{
					System.out.println("capability: "+_capability.getResource());
					
					
					
					//for(Reservation res:ct.getReservation())
						
					for(Reservation res:reservSet)
					{
						for(TimeInterval tv:res.getTimeInterval())
						{
							if( compareTwoDate(tv.getDate(),dateSelected))
								startTimeReservedSingleCourt.add(tv.getStartTime());
							
						}
						
					}
					
					//if the start time user choose isn't in the set of start time set reserved, then add this court or hall as available
					if(!startTimeReservedSingleCourt.contains(Integer.parseInt(_startTimeRecieved)))
					{			
						System.out.println("this court can be reserved");
						_courtsAvailable.add(ct);				
					}
					
					
				}
			
				
			
		}
		
		
		Set<Court> courtTemp=new HashSet<Court>();
		for(Court ct:_courtsAvailable)
			courtTemp.add(new Court(ct.getId(),ct.getName(),ct.getIntroduction()));
			
		return courtTemp;
	}
	
	@RequestMapping(value = "/getCourts", method = RequestMethod.POST)
	public @ResponseBody
	void getCourtSelected(@RequestBody String court) {

		_nameOfCourtRecieved=court;
		
		System.out.println("court selected: "+court);
		
	}
	
	
	@RequestMapping(value="/getUserInfo", method=RequestMethod.POST)
	public @ResponseBody void getUserInfo(@RequestBody String user)
	{				

		String[] userInfoTemp=user.split(","); 
		_subscriber.setName(userInfoTemp[0]);
		_subscriber.setEmail(userInfoTemp[1]);
		_subscriber.setTelephone(userInfoTemp[2]);
		UUID uniqueKey1= UUID.randomUUID();
		UUID uniqueKey2= UUID.randomUUID();
		String key=uniqueKey1.toString()+uniqueKey2.toString();
		_subscriber.setId(UUID.randomUUID().toString());
		_subscriber.setAuthenKey(key);
		System.out.println("user info:"+_subscriber.getName()+" "+_subscriber.getEmail()+" "+_subscriber.getTelephone());
		
		saveReservation();
		cleanVaribalesAfterSubmit();
		testingIntegerFlag++;
		
	}
	
	
	public void saveReservation()
	{
		subscriberService.saveSubscriber(_subscriber);
		TimeInterval tal=new TimeInterval(UUID.randomUUID().toString(),Integer.parseInt(_startTimeRecieved),dateSelected);
		Set<TimeInterval> tals=new HashSet<TimeInterval>();
		tals.add(tal);
		timeIntervalService.saveTimeSet(tals);
		
		
		System.out.println(_nameOfHallRecieved
				+_nameOfCourtRecieved+" "
			
				+_startTimeRecieved +" "+_capability.getResource()+" " +_subscriber.getName()+" "+_subscriber.getEmail()+" "+_subscriber.getTelephone());
		int startTimeRecieved = Integer.parseInt(_startTimeRecieved);
		Reservation res=new Reservation();
		res.setId(UUID.randomUUID().toString());
		res.setDiscription("You have reserved " +_capability.getResource()+" at "+ _nameOfCourtRecieved+" in " +_nameOfHallRecieved +" from "+ startTimeRecieved+" to "+(startTimeRecieved+1)+". See you there!");
		res.setTips("no");
		res.setCourt(courtService.getCourtByName(_nameOfCourtRecieved));
		res.setSubscriber(_subscriber);
		res.setTimeInterval(tals);
		reservationService.saveReservation(res);
		
	}
	
	
	
	

	

	
	public void cleanVaribalesAfterSubmit()
	{
		System.out.println("clean all after you reserve successfully!");
		
		_capability=new Capability();		
		_allCourtsThisCap.clear();
		
		dateSelected=null;
		_timeIntervals.clear();
		_reservations.clear();
		
		_startTimeSetAvailable.clear();
		_startTimeRecieved=null;
		
		_hallsAvailable.clear();
		_nameOfHallRecieved=null;
		
		_courtsAvailable.clear();
		_nameOfCourtRecieved=null;		
		
		_subscriber=new Subscriber();
		
		
	}
	
	public void cleanVariablesAfterSelectSports()
	{
		System.out.println("cleanVariablesAfterSelectSports");
		
		dateSelected=null;
		_timeIntervals.clear();
		_reservations.clear();
		
		_startTimeSetAvailable.clear();
		_startTimeRecieved=null;
		
		_hallsAvailable.clear();
		_nameOfHallRecieved=null;
		
		_courtsAvailable.clear();
		_nameOfCourtRecieved=null;		
		
		_subscriber=new Subscriber();

		
	}
	
	public void cleanVariablesAfterSelectDate()
	{
		System.out.println("cleanVariablesAfterSelectDate");
		_startTimeSetAvailable.clear();
		_startTimeRecieved=null;
		
		_hallsAvailable.clear();
		_nameOfHallRecieved=null;
		
		_courtsAvailable.clear();
		_nameOfCourtRecieved=null;		
		
		_subscriber=new Subscriber();
		
	}
	
	public void cleanVariablesAfterSelectTimeInterval()
	{
		System.out.println("cleanVariablesAfterSelectTimeInterval");
		_hallsAvailable.clear();
		_nameOfHallRecieved=null;
		
		_courtsAvailable.clear();
		_nameOfCourtRecieved=null;		
		
		_subscriber=new Subscriber();
		
	}
	public void cleanVariablesAfterSelectHall()
	{
		System.out.println("cleanVariablesAfterSelectHall");
		_courtsAvailable.clear();
		_nameOfCourtRecieved=null;		
		
		_subscriber=new Subscriber();
		
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

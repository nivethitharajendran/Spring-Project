package com.lti;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {

	public static void main(String[] args) {
		//System.out.println("Spring test2");
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("spring2.xml");
		System.out.println(ctx);
		 System.out.println("loaded the container..."+ctx);
	        FlightRepository flightRepo = (FlightRepository ) ctx.getBean("flightRepo");
	        List<Flight> flList = flightRepo.getAvailableFlights();
	        for (Flight f : flList) {
	            System.out.println("Flight number :  "+f.getFlightNumber());
	            System.out.println("Flight name   :  "+f.getFlightName());
	            System.out.println("Flight source :  "+f.getFlightSource());
	            System.out.println("Flight dest   :  "+f.getFlightDestination());
	            System.out.println("--------------------");
	        }
		
	}

}
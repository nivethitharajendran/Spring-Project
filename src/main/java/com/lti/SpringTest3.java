package com.lti;
import java.util.List;

 

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 

public class SpringTest3 {
    public static void main(String[] args) {

 

        System.out.println("loading spring container...");
        //light weight container
        AbstractApplicationContext ctx = new 
                ClassPathXmlApplicationContext("spring2.xml");
        System.out.println("loaded the container..."+ctx);
        FlightRepository2 flightRepo = (FlightRepository2 ) ctx.getBean("flightRepo2");
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
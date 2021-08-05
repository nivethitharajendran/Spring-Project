package com.lti;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

 

@Entity
@Table(name="flights")
public class Flight { // upcoming pojo for JPA
	@Id
	@Column(name="flight_no")
    private int flightNumber;
	
	@Column(name="flight_name")
    private String flightName;
	
	@Column(name="source")
    private String flightSource;
	
	@Column(name="destination")
    private String flightDestination;
    
    public Flight() {
        System.out.println("Flight ctor...");
    }
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public String getFlightName() {
        return flightName;
    }
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
    public String getFlightSource() {
        return flightSource;
    }
    public void setFlightSource(String flightSource) {
        this.flightSource = flightSource;
    }
    public String getFlightDestination() {
        return flightDestination;
    }
    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }
    
    
}
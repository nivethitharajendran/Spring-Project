package com.lti;

 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.sql.DataSource;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component(value = "flightRepo2") //no need of <bean> tag in the xml, @Service, @Repository, @Controller
@Scope(value = "prototype")
public class FlightRepository2 { //Car
    
    EntityManagerFactory entityManagerFactory;

 

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory factory) {
        System.out.println("setEntityManagerFactory() invoked..."+factory);
        entityManagerFactory = factory;
    }
    
    public FlightRepository2() {    
        System.out.println("FlightRepository2 ctor...");    
    }
    
    @Transactional
    public List getAvailableFlights() {
        System.out.println("FlightRepository2 : getAvailableFlights() invoked...");
        List<Flight> flightList = new ArrayList<Flight>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction tx = entityManager.getTransaction();
        //tx.begin();
        Query query = entityManager.createQuery(" from Flight");
        //tx.commit();
        return query.getResultList();
    }
    
}
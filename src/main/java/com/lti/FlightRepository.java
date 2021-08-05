package com.lti;
 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component(value = "flightRepo") //no need of <bean> tag in the xml, @Service, @Repository, @Controller
@Scope(value = "prototype")
public class FlightRepository { //Car

    DataSource dataSource; //Wheel
 
                //setWheel( ... )
    @Autowired
    
    public void setDataSource(DataSource dataSource) {
        System.out.println("setDataSource() invoked...");
        this.dataSource = dataSource;
    }
    
    public List getAvailableFlights() {

        List<Flight> flightList = new ArrayList<Flight>();

        System.out.println("getAvailableFlights() invoked...");
        try {
            Connection conn = dataSource.getConnection();
            System.out.println("Connected..."+conn);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from flights");
            while(rs.next()) {
                Flight f = new Flight();
                f.setFlightNumber(rs.getInt(1));
                f.setFlightName(rs.getString(2));
                f.setFlightSource(rs.getString(3));
                f.setFlightDestination(rs.getString(4));
                flightList.add(f);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flightList;   
    }
}
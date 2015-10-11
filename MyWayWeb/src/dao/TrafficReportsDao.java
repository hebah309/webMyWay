package dao;

import java.util.List;

import model.TrafficReports;


public interface TrafficReportsDao {
	
	
	List<TrafficReports> getAllTrafficReports();
	

	
    void addReport(TrafficReports trafficReport); 
	
	

}

package dao;

import java.util.List;

import model.TrafficReport;


public interface TrafficReportsDao {
	
	
	List<TrafficReport> getAllTrafficReports();
	
    void addReport(TrafficReport trafficReport); 
    
    void deleteReport(String reportId); 
	
	

}

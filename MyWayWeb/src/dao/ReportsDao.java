package dao;

import java.util.List;

import model.IncidentReport;

public interface ReportsDao {
	
	List<IncidentReport> getAllPendingReports();
	
	void updateReportStatus(int id, String status);
	
    void addReport(IncidentReport incidentReport); 
}

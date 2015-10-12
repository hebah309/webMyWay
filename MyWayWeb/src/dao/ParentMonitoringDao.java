package dao;

import java.util.List;

import model.DriverDashBoard;
import model.DriverReport;
import model.UserProfile;

public interface ParentMonitoringDao {
	
	public List<UserProfile> getAllDrivers(String parentUserName);
	
	public void addDriver(String parentUserName,UserProfile driver);

	public List<DriverReport> getAllDriverReports(UserProfile driverProfile);
	
	
	public DriverDashBoard getDriverDashBoard(UserProfile driverProfile);

}

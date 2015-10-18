package dao;

import java.util.List;
import model.DriverDashBoard;
import model.DriverReport;
import model.UserProfile;
import model.DriverDestination;

public interface ParentMonitoringDao {
	
	public List<UserProfile> getAllDrivers(String parentUserName);
	
	public void addDriver(String parentUserName,UserProfile driver);

	public List<DriverReport> getAllDriverReports(UserProfile driverProfile);
	
	public void addDriverReports(DriverReport driverReport);
	
	public DriverDashBoard getDriverDashBoard(UserProfile driverProfile);
	
	public void setDriverDestination(DriverDestination driverDestination);

	public DriverDestination getDriverDestination(UserProfile driverProfile);

	public void setDriverDashBoard(DriverDashBoard driverDashBoard);

}

package dao;

import java.util.List;

import model.Journey;

public interface ParentsMonitoringDao {
	
	List<Journey> getJourneysForParent(String userName);

}

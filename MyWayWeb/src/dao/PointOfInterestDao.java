package dao;

import java.util.List;
import model.POIType;
import model.PointOfInterest;

public interface PointOfInterestDao {
	
	List<POIType> getPOITypes();

	void submitPOI(PointOfInterest poi);
	
	List<PointOfInterest> getPOIs();
	
	void reviewPOI(String choice, int id);
	
	List<PointOfInterest> getPendingPOIs() ;
}

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DriverDestination {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@OneToOne
	private UserProfile userProfile;
	
	private String Lat;
	private String Lon;
	
	
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getLon() {
		return Lon;
	}
	public void setLon(String lon) {
		Lon = lon;
	}
	public DriverDestination(){
		
	}
	public DriverDestination(UserProfile userProfile, String lat, String lon) {
		super();
		this.userProfile = userProfile;
		Lat = lat;
		Lon = lon;
	}
	
	

}

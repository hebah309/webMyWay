package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DriverDashBoard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@OneToOne
	private UserProfile userProfile;
	
	
	private String battaryStatus;
	private String currentLat;
	private String currentLon;
	
	public String getBattaryStatus() {
		return battaryStatus;
	}
	public void setBattaryStatus(String battaryStatus) {
		this.battaryStatus = battaryStatus;
	}
	public String getCurrentLat() {
		return currentLat;
	}
	public void setCurrentLat(String currentLat) {
		this.currentLat = currentLat;
	}
	public String getCurrentLon() {
		return currentLon;
	}
	public void setCurrentLon(String currentLon) {
		this.currentLon = currentLon;
	}
	public DriverDashBoard(){
		
	}
	public DriverDashBoard(UserProfile userProfile, String battaryStatus,
			String currentLat, String currentLon) {
		super();
		this.userProfile = userProfile;
		this.battaryStatus = battaryStatus;
		this.currentLat = currentLat;
		this.currentLon = currentLon;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	

}

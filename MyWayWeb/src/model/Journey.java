package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Journey {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Location currentLocation;
	
	private int speed;
	private String FinalDestination;
	private float speedAverage;
	private String stops;
	
	@ManyToOne
	@JoinColumn(name="userId")
	UserInfo user ;
	
	@Transient
	String username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getFinalDestination() {
		return FinalDestination;
	}
	public void setFinalDestination(String finalDestination) {
		FinalDestination = finalDestination;
	}
	public float getSpeedAverage() {
		return speedAverage;
	}
	public void setSpeedAverage(float speedAverage) {
		this.speedAverage = speedAverage;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	

	public UserInfo getUser() {
		return user;
	}
	
	public void setUser(UserInfo user) {
		this.user = user;
		username=user.getUserName();
	}

}

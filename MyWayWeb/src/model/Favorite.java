package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Favorite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int favId;
	
	@ManyToOne
	private UserProfile userProfile;
	
	private String name;
	
	private String latitude;
	private String longitude;
	
	public Favorite(){
		
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	public Favorite(UserProfile userProfile, String name, String latitude,
			String longitude) {
		super();
		this.userProfile = userProfile;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}

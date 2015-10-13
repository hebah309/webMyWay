package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "userProfile", uniqueConstraints = { @UniqueConstraint(columnNames = { "userName" }) })
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "userName")
	private String userName;

	private String passWord;
	private String email;

	@Column(columnDefinition="LONGTEXT")
	private String profilePicture;
	
	private String parent;
	
	
	@OneToMany(mappedBy = "userProfile", cascade=CascadeType.ALL)
	List<Event> events;
	
	@OneToMany(mappedBy = "userProfile", cascade=CascadeType.ALL)
	List<TrafficReport> trafficReports;
	
	@OneToMany(mappedBy = "userProfile", cascade=CascadeType.ALL)
	List<Favorite> favorites;
	
	@OneToMany(mappedBy = "userProfile", cascade=CascadeType.ALL)
	List<DriverReport> driverReports;
	
	@OneToOne(mappedBy = "userProfile", cascade=CascadeType.ALL)
	DriverDashBoard driverDashBoard;
	
	@OneToOne(mappedBy = "userProfile", cascade=CascadeType.ALL)
	DriverDestination driverDestination;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	

}

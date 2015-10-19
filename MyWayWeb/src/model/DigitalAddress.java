package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DigitalAddress {

	@Id
	private int digitalNumber;
	
	private String latitude;
	private String longitude;
	private String block;
	private String area;
	private String street;
	private String building;
	
	public DigitalAddress(){
		
	}
	
	public DigitalAddress(int digitalNumber, String latitude, String longitude,
			String block, String area, String street, String building) {
		super();
		this.digitalNumber = digitalNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.block = block;
		this.area = area;
		this.street = street;
		this.building = building;
	}
	
	public int getDigitalNumber() {
		return digitalNumber;
	}
	public void setDigitalNumber(int digitalNumber) {
		this.digitalNumber = digitalNumber;
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
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	
	
	
}

package model;

import javax.persistence.*;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String longtitude;
	
	private String latitude;
	
	@OneToOne(mappedBy="location")
	private IncidentReport incidentReport;
	
	@OneToOne(mappedBy="currentLocation")
	private Journey journey;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public IncidentReport getIncidentReport() {
		return incidentReport;
	}

	public void setIncidentReport(IncidentReport incidentReport) {
		this.incidentReport = incidentReport;
	}
	
}
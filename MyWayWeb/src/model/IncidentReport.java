package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="INCIDENTREPORT")
public class IncidentReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String reportType;
	
	private String reportDescription;
	
	private String trafficDensity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportTime;
		
	private String voiceNotificationPath;
	
	private String reportStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Location location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getVoiceNotificationPath() {
		return voiceNotificationPath;
	}

	public void setVoiceNotificationPath(String voiceNotificationPath) {
		this.voiceNotificationPath = voiceNotificationPath;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getTrafficDensity() {
		return trafficDensity;
	}

	public void setTrafficDensity(String trafficDensity) {
		this.trafficDensity = trafficDensity;
	}
	
}
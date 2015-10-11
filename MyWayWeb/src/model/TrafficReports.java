package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TrafficReports")
public class TrafficReports {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reportId;
	private int reportTypeId;
	private String comment;
	private String lat;
	private String lon;
	private String username;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getReportTypeId() {
		return reportTypeId;
	}
	public void setReportTypeId(int reportTypeId) {
		this.reportTypeId = reportTypeId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	
}

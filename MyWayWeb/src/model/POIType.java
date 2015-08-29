package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries(@NamedQuery(name="getPoiTypes",query="select t from POIType t"))
@Entity
public class POIType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeId;
	
	private String type;
	
	@OneToMany(mappedBy="poiType", cascade=CascadeType.ALL)
	private List<PointOfInterest> pointsOfInterests;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}

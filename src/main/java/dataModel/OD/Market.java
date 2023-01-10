package dataModel.OD;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This model is to create market java object
 * Data is getting loaded from XML File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
@XmlRootElement(name = "market")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Market implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String state;
	private String latitude;
	private String longitude;
	private String visible;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Market [name=" + name + ", state=" + state + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", visible=" + visible + "]";
	}


}

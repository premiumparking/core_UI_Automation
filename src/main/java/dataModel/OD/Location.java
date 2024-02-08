package dataModel.OD;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This model is to create location java object
 * Data is getting loaded from XML File
 * 
 * Author : Venu Thota(venu.thota@xebia.com)
 */

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rates;
	private String reservations;
	private String durations;
	private String locationType;
	private String requestMonthlyParking;
	private String market;
	private String name;
	private String propertyName;
	private String latitude;
	private String longitude;
	private String address;
	private String city;
	private String zip;
	public String getRates() {
		return rates;
	}
	public void setRates(String rates) {
		this.rates = rates;
	}
	public String getReservations() {
		return reservations;
	}
	public void setReservations(String reservations) {
		this.reservations = reservations;
	}
	public String getDurations() {
		return durations;
	}
	public void setDurations(String durations) {
		this.durations = durations;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getRequestMonthlyParking() {
		return requestMonthlyParking;
	}
	public void setRequestMonthlyParking(String requestMonthlyParking) {
		this.requestMonthlyParking = requestMonthlyParking;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Location [rates=" + rates + ", reservations=" + reservations + ", durations=" + durations
				+ ", locationType=" + locationType + ", requestMonthlyParking=" + requestMonthlyParking + ", market="
				+ market + ", name=" + name + ", propertyName=" + propertyName + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", address=" + address + ", city=" + city + ", zip=" + zip + "]";
	}
	
	

}

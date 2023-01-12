package dataModel.TextPay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/*
 * This model is to create Guest java object
 * Data is getting loaded from XML File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
@XmlRootElement(name = "guest")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String licensePlateNumber;
	private String state;
	private String zip;
	private String locationNumber;
	private String ccNumber;
	private String expiry;
	private String cvc;
	private String amount;
	private String timeInHours;
	private String parkingType;
	private String promocode;
	private String paymentVia;
	private String vehicleType;
	private String make;
	private String type;
	private String color;

	public String getMake() {	return make;	}

	public void setMake(String make) {	this.make = make;	}

	public String getType() {	return type;	}

	public void setType(String type) {	this.type = type;	}

	public String getColor() {	return color;	}

	public void setColor(String color) { this.color = color; }

	public String getVehicleType() { return vehicleType; }

	public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getTimeInHours() { return timeInHours; }

	public void setTimeInHours(String timeInHours) { this.timeInHours = timeInHours; }

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public String getPaymentVia() {
		return paymentVia;
	}

	public void setPaymentVia(String paymentVia) {
		this.paymentVia = paymentVia;
	}

}

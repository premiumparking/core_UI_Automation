package dataModel.SPA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/*
 * This model is to create Vehicle java object
 * Data is getting loaded from XML File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */

@Getter
@Setter
@XmlRootElement(name = "vehicle")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	private String licensePlateNumber;
	private String state;
	private String zip;
	private String locationNumber;
	private String ccNumber;
	private String expiry;
	private String cvc;
	private String amount;
	private String promoCode;
	private String timeInHours;
	private String extendTime;
	private String payOption;
	private Boolean isItNewCard;
	private Boolean isItNewVehicle;
	private Boolean isItNewSession;
	private Boolean isItNewReservation;
	private Boolean isItExtended;
	private Boolean isItFutureReservation;

	public Boolean getIsItNewReservation() { return isItNewReservation;	}

	public void setIsItNewReservation(Boolean itNewReservation) { isItNewReservation = itNewReservation; }

	public Boolean getIsItFutureReservation() {	return isItFutureReservation;}

	public void setIsItFutureReservation(Boolean itFutureReservation) {	isItFutureReservation = itFutureReservation;}

	public Boolean getIsItExtended() {
		return isItExtended;
	}

	public void setIsItExtended(Boolean isItExtended) {
		this.isItExtended = isItExtended;
	}

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

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getTimeInHours() {
		return timeInHours;
	}

	public void setTimeInHours(String timeInHours) {
		this.timeInHours = timeInHours;
	}

	public String getExtendTime() {
		return extendTime;
	}

	public void setExtendTime(String extendTime) {
		this.extendTime = extendTime;
	}

	public String getPayOption() {
		return payOption;
	}

	public void setPayOption(String payOption) {
		this.payOption = payOption;
	}

	public Boolean getIsItNewCard() {
		return isItNewCard;
	}

	public void setIsItNewCard(Boolean isItNewCard) {
		this.isItNewCard = isItNewCard;
	}

	public Boolean getIsItNewVehicle() {
		return isItNewVehicle;
	}

	public void setIsItNewVehicle(Boolean isItNewVehicle) {
		this.isItNewVehicle = isItNewVehicle;
	}

	public Boolean getIsItNewSession() {
		return isItNewSession;
	}

	public void setIsItNewSession(Boolean isItNewSession) {
		this.isItNewSession = isItNewSession;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePlateNumber=" + licensePlateNumber + ", state=" + state + ", zip=" + zip
				+ ", locationNumber=" + locationNumber + ", ccNumber=" + ccNumber + ", expiry=" + expiry + ", cvc="
				+ cvc + ", amount=" + amount + ", promoCode=" + promoCode + ", timeInHours=" + timeInHours
				+ ", extendTime=" + extendTime + ", payOption=" + payOption + ", isItNewCard=" + isItNewCard
				+ ", isItNewVehicle=" + isItNewVehicle + ", isItNewSession=" + isItNewSession
				+ ", isItNewnewReservation=" + isItNewReservation + ", isItExtended=" + isItExtended + ", isItFutureReservation=" + isItFutureReservation + "]";
	}

}

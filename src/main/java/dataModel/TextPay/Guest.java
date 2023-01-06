package dataModel.TextPay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

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

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getTimeInHours() {
		return timeInHours;
	}

	public void setTimeInHours(String timeInHours) {
		this.timeInHours = timeInHours;
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

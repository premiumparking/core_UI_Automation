package dataModel.TextPay;

public class PurchaseDetails {
	private String orderNumber;
	private String licensePlate;
	private String state;
	private String locationNumber;
	private String channel;
	private String purchaseType;
	private String promocode;
	private String rateName;
	private String durationInWords;
	private String amountCharged;
	private String paymentOption;
	private String paymentMethod;
	private String spaceType;
	private String email;
	private Boolean unKnownVehicle;
	private String enf_licensePlate;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Boolean getUnKnownVehicle() {
		return unKnownVehicle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public String getDurationInWords() {
		return durationInWords;
	}

	public void setDurationInWords(String durationInWords) {
		this.durationInWords = durationInWords;
	}

	public String getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(String amountCharged) {
		this.amountCharged = amountCharged;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isUnKnownVehicle() {
		return unKnownVehicle;
	}

	public void setUnKnownVehicle(Boolean unKnownVehicle) {
		this.unKnownVehicle = unKnownVehicle;
	}

	public String getEnf_licensePlate() {
		return enf_licensePlate;
	}

	public void setEnf_licensePlate(String enf_licensePlate) {
		this.enf_licensePlate = enf_licensePlate;
	}
	
	

}

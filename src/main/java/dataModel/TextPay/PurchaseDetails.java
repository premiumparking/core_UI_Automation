package dataModel.TextPay;

public class PurchaseDetails {
	private String orderNumber;
	private String licencePlate;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
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

}

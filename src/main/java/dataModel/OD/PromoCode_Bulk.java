package dataModel.OD;

import java.io.Serializable;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

/*
 * This model is to create Promo Code java object
 * Data is getting loaded from Excel File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class PromoCode_Bulk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExcelRow
	private int row;

	@ExcelCellName("Name")
	private String promoCode;

	@ExcelCellName("Discount")
	private String discount;

	@ExcelCellName("Starts")
	private String startDate;

	@ExcelCellName("Ends")
	private String endDate;

	@ExcelCellName("Active week days")
	private String weekDays;

	@ExcelCellName("Active time")
	private String activeTime;

	@ExcelCellName("Available types")
	private String availableTypes;

	@ExcelCellName("Available locations")
	private String availableLocations;

	@ExcelCellName("Amount of uses")
	private String amountOfUsers;

	@ExcelCellName("Amount of Subscription Valid Periods")
	private String subscriptionValidPeriods;

	@ExcelCellName("Max Active at Same Time (Quantity)")
	private String quantity;

	@ExcelCellName("Max Active at Same Time (Grace Period)")
	private String gracePeriod;

	@ExcelCellName("Min Hours")
	private String minHours;

	@ExcelCellName("Max Hours")
	private String maxHours;

	@ExcelCellName("Once per account")
	private String oncePerAccount;

	@ExcelCellName("Only Valid Before Parking Starts")
	private String beforeParkingStarts;

	@ExcelCellName("Notes")
	private String notes;

	@ExcelCellName("Business Account Name")
	private String businessAccountName;

	@ExcelCellName("Fee Amount")
	private String feeAmount;

	@ExcelCellName("Event Exempt")
	private String eventExempt;

	@ExcelCellName("Refund Service Fee")
	private String refundServiceFee;

	@ExcelCellName("No Discount Or Validation Restrictions")
	private String noDiscount;

	@ExcelCellName("Tag")
	private String tag;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public String getAvailableTypes() {
		return availableTypes;
	}

	public void setAvailableTypes(String availableTypes) {
		this.availableTypes = availableTypes;
	}

	public String getAvailableLocations() {
		return availableLocations;
	}

	public void setAvailableLocations(String availableLocations) {
		this.availableLocations = availableLocations;
	}

	public String getAmountOfUsers() {
		return amountOfUsers;
	}

	public void setAmountOfUsers(String amountOfUsers) {
		this.amountOfUsers = amountOfUsers;
	}

	public String getSubscriptionValidPeriods() {
		return subscriptionValidPeriods;
	}

	public void setSubscriptionValidPeriods(String subscriptionValidPeriods) {
		this.subscriptionValidPeriods = subscriptionValidPeriods;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(String gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public String getMinHours() {
		return minHours;
	}

	public void setMinHours(String minHours) {
		this.minHours = minHours;
	}

	public String getMaxHours() {
		return maxHours;
	}

	public void setMaxHours(String maxHours) {
		this.maxHours = maxHours;
	}

	public String getOncePerAccount() {
		return oncePerAccount;
	}

	public void setOncePerAccount(String oncePerAccount) {
		this.oncePerAccount = oncePerAccount;
	}

	public String getBeforeParkingStarts() {
		return beforeParkingStarts;
	}

	public void setBeforeParkingStarts(String beforeParkingStarts) {
		this.beforeParkingStarts = beforeParkingStarts;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getBusinessAccountName() {
		return businessAccountName;
	}

	public void setBusinessAccountName(String businessAccountName) {
		this.businessAccountName = businessAccountName;
	}

	public String getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getEventExempt() {
		return eventExempt;
	}

	public void setEventExempt(String eventExempt) {
		this.eventExempt = eventExempt;
	}

	public String getRefundServiceFee() {
		return refundServiceFee;
	}

	public void setRefundServiceFee(String refundServiceFee) {
		this.refundServiceFee = refundServiceFee;
	}

	public String getNoDiscount() {
		return noDiscount;
	}

	public void setNoDiscount(String noDiscount) {
		this.noDiscount = noDiscount;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PromoCode_Bulk [row=" + row + ", promoCode=" + promoCode + ", discount=" + discount + ", startDate="
				+ startDate + ", endDate=" + endDate + ", weekDays=" + weekDays + ", activeTime=" + activeTime
				+ ", availableTypes=" + availableTypes + ", availableLocations=" + availableLocations
				+ ", amountOfUsers=" + amountOfUsers + ", subscriptionValidPeriods=" + subscriptionValidPeriods
				+ ", quantity=" + quantity + ", gracePeriod=" + gracePeriod + ", minHours=" + minHours + ", maxHours="
				+ maxHours + ", oncePerAccount=" + oncePerAccount + ", beforeParkingStarts=" + beforeParkingStarts
				+ ", notes=" + notes + ", businessAccountName=" + businessAccountName + ", feeAmount=" + feeAmount
				+ ", eventExempt=" + eventExempt + ", refundServiceFee=" + refundServiceFee + ", noDiscount="
				+ noDiscount + ", tag=" + tag + "]";
	}

}

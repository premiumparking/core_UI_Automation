package dataModel.Admiral;

import java.io.Serializable;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

/*
 * This model is to create Citation java object
 * Data is getting loaded from Excel File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */

public class Citation implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExcelRow
	private int row;

	@ExcelCellName("Date")
	private String date;

	@ExcelCellName("Time")
	private String time;

	@ExcelCellName("Time Zone")
	private String timeZone;

	@ExcelCellName("Gross Sales")
	private String grossSales;

	@ExcelCellName("Discounts")
	private String discounts;

	@ExcelCellName("Service Charges")
	private String serviceCharges;

	@ExcelCellName("Net Sales")
	private String netSales;

	@ExcelCellName("Gift Card Sales")
	private String GiftCardSales;

	@ExcelCellName("Tax")
	private String tax;

	@ExcelCellName("Tip")
	private String tip;

	@ExcelCellName("Partial Refunds")
	private String partialRefunds;

	@ExcelCellName("Total Collected")
	private String totalCollected;

	@ExcelCellName("Source")
	private String source;

	@ExcelCellName("Card")
	private String card;

	@ExcelCellName("Card Entry Methods")
	private String cardEntryMethods;

	@ExcelCellName("Cash")
	private String cash;

	@ExcelCellName("Square Gift Card")
	private String squareGiftCard;

	@ExcelCellName("Other Tender")
	private String otherTender;

	@ExcelCellName("Other Tender Type")
	private String otherTenderType;

	@ExcelCellName("Other Tender Note")
	private String otherTenderNote;

	@ExcelCellName("Fees")
	private String fees;

	@ExcelCellName("Net Total")
	private String netTotal;

	@ExcelCellName("Transaction ID")
	private String transactionID;

	@ExcelCellName("Payment ID")
	private String paymentID;

	@ExcelCellName("Card Brand")
	private String cardBrand;

	@ExcelCellName("PAN Suffix")
	private String panSuffix;

	@ExcelCellName("Device Name")
	private String deviceName;

	@ExcelCellName("Staff Name")
	private String staffName;

	@ExcelCellName("Staff ID")
	private String staffID;

	@ExcelCellName("Details")
	private String details;

	@ExcelCellName("Description")
	private String description;

	@ExcelCellName("Event Type")
	private String eventType;

	@ExcelCellName("Location")
	private String location;

	@ExcelCellName("Dining Option")
	private String diningOption;

	@ExcelCellName("Customer ID")
	private String customerID;

	@ExcelCellName("Customer Name")
	private String customerName;

	@ExcelCellName("Customer Reference ID")
	private String customerReferenceID;

	@ExcelCellName("Device Nickname")
	private String deviceNickname;

	@ExcelCellName("Deposit ID")
	private String depositID;

	@ExcelCellName("Deposit Date")
	private String depositDate;

	@ExcelCellName("Deposit Details")
	private String depositDetails;

	@ExcelCellName("Fee Percentage Rate")
	private String feePercentageRate;

	@ExcelCellName("Fee Fixed Rate")
	private String feeFixedRate;

	@ExcelCellName("Refund Reason")
	private String refundReason;

	@ExcelCellName("Discount Name")
	private String discountName;

	@ExcelCellName("Transaction Status")
	private String transactionStatus;

	@ExcelCellName("Cash App")
	private String cashApp;

	@ExcelCellName("Order Reference ID")
	private String orderReferenceID;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(String grossSales) {
		this.grossSales = grossSales;
	}

	public String getDiscounts() {
		return discounts;
	}

	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}

	public String getServiceCharges() {
		return serviceCharges;
	}

	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public String getNetSales() {
		return netSales;
	}

	public void setNetSales(String netSales) {
		this.netSales = netSales;
	}

	public String getGiftCardSales() {
		return GiftCardSales;
	}

	public void setGiftCardSales(String giftCardSales) {
		GiftCardSales = giftCardSales;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getPartialRefunds() {
		return partialRefunds;
	}

	public void setPartialRefunds(String partialRefunds) {
		this.partialRefunds = partialRefunds;
	}

	public String getTotalCollected() {
		return totalCollected;
	}

	public void setTotalCollected(String totalCollected) {
		this.totalCollected = totalCollected;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCardEntryMethods() {
		return cardEntryMethods;
	}

	public void setCardEntryMethods(String cardEntryMethods) {
		this.cardEntryMethods = cardEntryMethods;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getSquareGiftCard() {
		return squareGiftCard;
	}

	public void setSquareGiftCard(String squareGiftCard) {
		this.squareGiftCard = squareGiftCard;
	}

	public String getOtherTender() {
		return otherTender;
	}

	public void setOtherTender(String otherTender) {
		this.otherTender = otherTender;
	}

	public String getOtherTenderType() {
		return otherTenderType;
	}

	public void setOtherTenderType(String otherTenderType) {
		this.otherTenderType = otherTenderType;
	}

	public String getOtherTenderNote() {
		return otherTenderNote;
	}

	public void setOtherTenderNote(String otherTenderNote) {
		this.otherTenderNote = otherTenderNote;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(String netTotal) {
		this.netTotal = netTotal;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public String getPanSuffix() {
		return panSuffix;
	}

	public void setPanSuffix(String panSuffix) {
		this.panSuffix = panSuffix;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDiningOption() {
		return diningOption;
	}

	public void setDiningOption(String diningOption) {
		this.diningOption = diningOption;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerReferenceID() {
		return customerReferenceID;
	}

	public void setCustomerReferenceID(String customerReferenceID) {
		this.customerReferenceID = customerReferenceID;
	}

	public String getDeviceNickname() {
		return deviceNickname;
	}

	public void setDeviceNickname(String deviceNickname) {
		this.deviceNickname = deviceNickname;
	}

	public String getDepositID() {
		return depositID;
	}

	public void setDepositID(String depositID) {
		this.depositID = depositID;
	}

	public String getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

	public String getDepositDetails() {
		return depositDetails;
	}

	public void setDepositDetails(String depositDetails) {
		this.depositDetails = depositDetails;
	}

	public String getFeePercentageRate() {
		return feePercentageRate;
	}

	public void setFeePercentageRate(String feePercentageRate) {
		this.feePercentageRate = feePercentageRate;
	}

	public String getFeeFixedRate() {
		return feeFixedRate;
	}

	public void setFeeFixedRate(String feeFixedRate) {
		this.feeFixedRate = feeFixedRate;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getCashApp() {
		return cashApp;
	}

	public void setCashApp(String cashApp) {
		this.cashApp = cashApp;
	}

	public String getOrderReferenceID() {
		return orderReferenceID;
	}

	public void setOrderReferenceID(String orderReferenceID) {
		this.orderReferenceID = orderReferenceID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((GiftCardSales == null) ? 0 : GiftCardSales.hashCode());
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((cardBrand == null) ? 0 : cardBrand.hashCode());
		result = prime * result + ((cardEntryMethods == null) ? 0 : cardEntryMethods.hashCode());
		result = prime * result + ((cash == null) ? 0 : cash.hashCode());
		result = prime * result + ((cashApp == null) ? 0 : cashApp.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerReferenceID == null) ? 0 : customerReferenceID.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((depositDate == null) ? 0 : depositDate.hashCode());
		result = prime * result + ((depositDetails == null) ? 0 : depositDetails.hashCode());
		result = prime * result + ((depositID == null) ? 0 : depositID.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + ((deviceNickname == null) ? 0 : deviceNickname.hashCode());
		result = prime * result + ((diningOption == null) ? 0 : diningOption.hashCode());
		result = prime * result + ((discountName == null) ? 0 : discountName.hashCode());
		result = prime * result + ((discounts == null) ? 0 : discounts.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((feeFixedRate == null) ? 0 : feeFixedRate.hashCode());
		result = prime * result + ((feePercentageRate == null) ? 0 : feePercentageRate.hashCode());
		result = prime * result + ((fees == null) ? 0 : fees.hashCode());
		result = prime * result + ((grossSales == null) ? 0 : grossSales.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((netSales == null) ? 0 : netSales.hashCode());
		result = prime * result + ((netTotal == null) ? 0 : netTotal.hashCode());
		result = prime * result + ((orderReferenceID == null) ? 0 : orderReferenceID.hashCode());
		result = prime * result + ((otherTender == null) ? 0 : otherTender.hashCode());
		result = prime * result + ((otherTenderNote == null) ? 0 : otherTenderNote.hashCode());
		result = prime * result + ((otherTenderType == null) ? 0 : otherTenderType.hashCode());
		result = prime * result + ((panSuffix == null) ? 0 : panSuffix.hashCode());
		result = prime * result + ((partialRefunds == null) ? 0 : partialRefunds.hashCode());
		result = prime * result + ((paymentID == null) ? 0 : paymentID.hashCode());
		result = prime * result + ((refundReason == null) ? 0 : refundReason.hashCode());
		result = prime * result + row;
		result = prime * result + ((serviceCharges == null) ? 0 : serviceCharges.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((squareGiftCard == null) ? 0 : squareGiftCard.hashCode());
		result = prime * result + ((staffID == null) ? 0 : staffID.hashCode());
		result = prime * result + ((staffName == null) ? 0 : staffName.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
		result = prime * result + ((totalCollected == null) ? 0 : totalCollected.hashCode());
		result = prime * result + ((transactionID == null) ? 0 : transactionID.hashCode());
		result = prime * result + ((transactionStatus == null) ? 0 : transactionStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citation other = (Citation) obj;
		if (GiftCardSales == null) {
			if (other.GiftCardSales != null)
				return false;
		} else if (!GiftCardSales.equals(other.GiftCardSales))
			return false;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (cardBrand == null) {
			if (other.cardBrand != null)
				return false;
		} else if (!cardBrand.equals(other.cardBrand))
			return false;
		if (cardEntryMethods == null) {
			if (other.cardEntryMethods != null)
				return false;
		} else if (!cardEntryMethods.equals(other.cardEntryMethods))
			return false;
		if (cash == null) {
			if (other.cash != null)
				return false;
		} else if (!cash.equals(other.cash))
			return false;
		if (cashApp == null) {
			if (other.cashApp != null)
				return false;
		} else if (!cashApp.equals(other.cashApp))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerReferenceID == null) {
			if (other.customerReferenceID != null)
				return false;
		} else if (!customerReferenceID.equals(other.customerReferenceID))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (depositDate == null) {
			if (other.depositDate != null)
				return false;
		} else if (!depositDate.equals(other.depositDate))
			return false;
		if (depositDetails == null) {
			if (other.depositDetails != null)
				return false;
		} else if (!depositDetails.equals(other.depositDetails))
			return false;
		if (depositID == null) {
			if (other.depositID != null)
				return false;
		} else if (!depositID.equals(other.depositID))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (deviceNickname == null) {
			if (other.deviceNickname != null)
				return false;
		} else if (!deviceNickname.equals(other.deviceNickname))
			return false;
		if (diningOption == null) {
			if (other.diningOption != null)
				return false;
		} else if (!diningOption.equals(other.diningOption))
			return false;
		if (discountName == null) {
			if (other.discountName != null)
				return false;
		} else if (!discountName.equals(other.discountName))
			return false;
		if (discounts == null) {
			if (other.discounts != null)
				return false;
		} else if (!discounts.equals(other.discounts))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (feeFixedRate == null) {
			if (other.feeFixedRate != null)
				return false;
		} else if (!feeFixedRate.equals(other.feeFixedRate))
			return false;
		if (feePercentageRate == null) {
			if (other.feePercentageRate != null)
				return false;
		} else if (!feePercentageRate.equals(other.feePercentageRate))
			return false;
		if (fees == null) {
			if (other.fees != null)
				return false;
		} else if (!fees.equals(other.fees))
			return false;
		if (grossSales == null) {
			if (other.grossSales != null)
				return false;
		} else if (!grossSales.equals(other.grossSales))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (netSales == null) {
			if (other.netSales != null)
				return false;
		} else if (!netSales.equals(other.netSales))
			return false;
		if (netTotal == null) {
			if (other.netTotal != null)
				return false;
		} else if (!netTotal.equals(other.netTotal))
			return false;
		if (orderReferenceID == null) {
			if (other.orderReferenceID != null)
				return false;
		} else if (!orderReferenceID.equals(other.orderReferenceID))
			return false;
		if (otherTender == null) {
			if (other.otherTender != null)
				return false;
		} else if (!otherTender.equals(other.otherTender))
			return false;
		if (otherTenderNote == null) {
			if (other.otherTenderNote != null)
				return false;
		} else if (!otherTenderNote.equals(other.otherTenderNote))
			return false;
		if (otherTenderType == null) {
			if (other.otherTenderType != null)
				return false;
		} else if (!otherTenderType.equals(other.otherTenderType))
			return false;
		if (panSuffix == null) {
			if (other.panSuffix != null)
				return false;
		} else if (!panSuffix.equals(other.panSuffix))
			return false;
		if (partialRefunds == null) {
			if (other.partialRefunds != null)
				return false;
		} else if (!partialRefunds.equals(other.partialRefunds))
			return false;
		if (paymentID == null) {
			if (other.paymentID != null)
				return false;
		} else if (!paymentID.equals(other.paymentID))
			return false;
		if (refundReason == null) {
			if (other.refundReason != null)
				return false;
		} else if (!refundReason.equals(other.refundReason))
			return false;
		if (row != other.row)
			return false;
		if (serviceCharges == null) {
			if (other.serviceCharges != null)
				return false;
		} else if (!serviceCharges.equals(other.serviceCharges))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (squareGiftCard == null) {
			if (other.squareGiftCard != null)
				return false;
		} else if (!squareGiftCard.equals(other.squareGiftCard))
			return false;
		if (staffID == null) {
			if (other.staffID != null)
				return false;
		} else if (!staffID.equals(other.staffID))
			return false;
		if (staffName == null) {
			if (other.staffName != null)
				return false;
		} else if (!staffName.equals(other.staffName))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		if (totalCollected == null) {
			if (other.totalCollected != null)
				return false;
		} else if (!totalCollected.equals(other.totalCollected))
			return false;
		if (transactionID == null) {
			if (other.transactionID != null)
				return false;
		} else if (!transactionID.equals(other.transactionID))
			return false;
		if (transactionStatus == null) {
			if (other.transactionStatus != null)
				return false;
		} else if (!transactionStatus.equals(other.transactionStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citation [row=" + row + ", date=" + date + ", time=" + time + ", timeZone=" + timeZone + ", grossSales="
				+ grossSales + ", discounts=" + discounts + ", serviceCharges=" + serviceCharges + ", netSales="
				+ netSales + ", GiftCardSales=" + GiftCardSales + ", tax=" + tax + ", tip=" + tip + ", partialRefunds="
				+ partialRefunds + ", totalCollected=" + totalCollected + ", source=" + source + ", card=" + card
				+ ", cardEntryMethods=" + cardEntryMethods + ", cash=" + cash + ", squareGiftCard=" + squareGiftCard
				+ ", otherTender=" + otherTender + ", otherTenderType=" + otherTenderType + ", otherTenderNote="
				+ otherTenderNote + ", fees=" + fees + ", netTotal=" + netTotal + ", transactionID=" + transactionID
				+ ", paymentID=" + paymentID + ", cardBrand=" + cardBrand + ", panSuffix=" + panSuffix + ", deviceName="
				+ deviceName + ", staffName=" + staffName + ", staffID=" + staffID + ", details=" + details
				+ ", description=" + description + ", eventType=" + eventType + ", location=" + location
				+ ", diningOption=" + diningOption + ", customerID=" + customerID + ", customerName=" + customerName
				+ ", customerReferenceID=" + customerReferenceID + ", deviceNickname=" + deviceNickname + ", depositID="
				+ depositID + ", depositDate=" + depositDate + ", depositDetails=" + depositDetails
				+ ", feePercentageRate=" + feePercentageRate + ", feeFixedRate=" + feeFixedRate + ", refundReason="
				+ refundReason + ", discountName=" + discountName + ", transactionStatus=" + transactionStatus
				+ ", cashApp=" + cashApp + ", orderReferenceID=" + orderReferenceID + "]";
	}

}

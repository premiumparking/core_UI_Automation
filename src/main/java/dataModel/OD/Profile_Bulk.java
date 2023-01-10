package dataModel.OD;

import java.io.Serializable;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

/*
 * This model is to create profile java object
 * Data is getting loaded from Excel File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class Profile_Bulk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ExcelRow
	private int row;

	@ExcelCellName("Business Account Name")
	private String businessAccountName;

	@ExcelCellName("First Name")
	private String firstName;

	@ExcelCellName("Last Name")
	private String lastName;

	@ExcelCellName("Address")
	private String address;

	@ExcelCellName("Email")
	private String email;

	@ExcelCellName("Phone Number")
	private String phoneNumber;

	@ExcelCellName("Location")
	private String location;

	@ExcelCellName("Sub Rate Name")
	private String subRateName;

	@ExcelCellName("Sub Type")
	private String subType;

	@ExcelCellName("Sub Cost")
	private String subCost;

	@ExcelCellName("Payer")
	private String payer;

	@ExcelCellName("Start Date")
	private String startDate;

	@ExcelCellName("LP1 #")
	private String lpNumber;

	@ExcelCellName("LP1 State")
	private String lpState;

	@ExcelCellName("LP1 Make")
	private String lpMake;

	public Profile_Bulk(int rowIndex, String businessAccountName, String firstName, String lastName, String address,
			String email, String phoneNumber, String location, String subRateName, String subType, String subCost,
			String payer, String startDate, String lpNumber, String lpState, String lpMake) {
		super();
		this.row = rowIndex;
		this.businessAccountName = businessAccountName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.subRateName = subRateName;
		this.subType = subType;
		this.subCost = subCost;
		this.payer = payer;
		this.startDate = startDate;
		this.lpNumber = lpNumber;
		this.lpState = lpState;
		this.lpMake = lpMake;
	}

	public Profile_Bulk() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Profile_Bulk [row=" + row + ", businessAccountName=" + businessAccountName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", location=" + location + ", subRateName=" + subRateName + ", subType=" + subType
				+ ", subCost=" + subCost + ", payer=" + payer + ", startDate=" + startDate + ", lpNumber=" + lpNumber
				+ ", lpState=" + lpState + ", lpMake=" + lpMake + "]";
	}

	public int getRowIndex() {
		return row;
	}

	public void setRowIndex(int rowIndex) {
		this.row = rowIndex;
	}

	public String getBusinessAccountName() {
		return businessAccountName;
	}

	public void setBusinessAccountName(String businessAccountName) {
		this.businessAccountName = businessAccountName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSubRateName() {
		return subRateName;
	}

	public void setSubRateName(String subRateName) {
		this.subRateName = subRateName;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getSubCost() {
		return subCost;
	}

	public void setSubCost(String subCost) {
		this.subCost = subCost;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLpNumber() {
		return lpNumber;
	}

	public void setLpNumber(String lpNumber) {
		this.lpNumber = lpNumber;
	}

	public String getLpState() {
		return lpState;
	}

	public void setLpState(String lpState) {
		this.lpState = lpState;
	}

	public String getLpMake() {
		return lpMake;
	}

	public void setLpMake(String lpMake) {
		this.lpMake = lpMake;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

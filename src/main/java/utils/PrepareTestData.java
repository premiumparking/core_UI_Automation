package utils;

import components.BaseClass;
import components.Constants;
import dataModel.TextPay.Guest;

/*
 * Class is to handle the test data manipulations
 *
 * Author : Venu Thota(venu.thota@xebia.com)
 */
public class PrepareTestData extends BaseClass {

	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();

	// ****************** TEST DATA ****************************//
	Guest user = (Guest) xml_Ops.getTestData("guest");

	/*
	 * This method is to prepare the test data and return the user object
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public Guest get_User_Testdata(boolean isGuestRole, String vehicleIfo, String spaceTpe, int duration,
			boolean isNewPayment, String paymentMethod) {

		user.setLocationNumber(getRandomLocation());
		
		user.setParkingType(spaceTpe);
		if(duration!=0)
			user.setTimeInHours(duration+"");
		user.setGuestRole(isGuestRole);
		user.setNewPayment(isNewPayment);
		user.setEmail(getRandomEmailAddress());
		if (!isGuestRole)
			user.setMobileNumber(getRandomUSPhoneNumber());

		switch (paymentMethod) {
		case Constants.CARD:
			user.setPaymentVia(Constants.CARD);
			user.setCcNumber(Constants.VISA_CARD_NUMBER);
			break;
		case Constants.PROMOCODE:
			user.setPaymentVia(Constants.PROMOCODE);
			user.setPromocode(Constants.PROMO100);
			break;
		}
		switch (vehicleIfo) {
		case Constants.NEW_VEHICLE:
			user.setVehicleType(Constants.NEW_VEHICLE);
			user.setLicensePlateNumber(getRandomLicencePlate());
			break;
		case Constants.UNKNOWN_VEHICLE:
			user.setLicensePlateNumber(Constants.UNKNOWN);
			user.setVehicleType(Constants.UNKNOWN_VEHICLE);
			user.setType(getRandom_Vehicle_Type());
			user.setMake(getRandom_Vehicle_Make());
			user.setColor(getRandom_Vehicle_Color());
			break;
		case Constants.EXISTING_VEHICLE:
			break;
		}
		return user;
	}
}

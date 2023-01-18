package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create whitelist java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "whitelist")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Whitelist implements Serializable {
    private static final long serialVersionUID = 1L;

    private String state;
    private String licensePlate;
    private String accountNumber;
    private String name;
    private String vehicleMake;
    private String vehicleColor;
    private String accessLevel;
    private String permitNumber;
    private String location;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Whitelist [state=" + state + ", licensePlate=" + licensePlate + ",accountNumber=" + accountNumber + ", name=" + name + ", vehicleMake=" + vehicleMake + ", vehicleColor=" + vehicleColor + ",accessLevel=" + accessLevel + ", permitNumber=" + permitNumber + ", location=" + location + "]";
    }

}

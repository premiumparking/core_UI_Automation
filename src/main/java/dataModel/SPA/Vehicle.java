package dataModel.SPA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "vehicle")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    private String licensePlateNumber;
    private String state;
    private String zip;
    private String locationNumber;

    public String getLocationNumber() { return locationNumber; }
    public void setLocationNumber(String locationNumber) { this.locationNumber = locationNumber;}

    public String getLicensePlateNumber() { return licensePlateNumber; }
    public void setLicensePlateNumber(String licensePlateNumber) { this.licensePlateNumber = licensePlateNumber; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

}

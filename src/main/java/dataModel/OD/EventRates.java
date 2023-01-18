package dataModel.OD;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create event rates java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "eventRates")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EventRates implements Serializable {
    private static final long serialVersionUID = 1L;

    private String externalName;
    private String internalName;
    private String rateGroupTitle;
    private String rateLocation;
    private String rateName;
    private String rateMinutes;
    private String ratePrice;
    private String ratePreTaxPrice;

    public String getExternalName() { return externalName; }
    public void setExternalName(String externalName) { this.externalName = externalName; }
    public String getInternalName() { return internalName; }
    public void setInternalName(String internalName) { this.internalName = internalName; }
    public String getRateGroupTitle() { return rateGroupTitle;  }
    public void setRateGroupTitle(String rateGroupTitle) { this.rateGroupTitle = rateGroupTitle; }
    public String getRateLocation() { return rateLocation; }
    public void setRateLocation(String rateLocation) { this.rateLocation = rateLocation; }
    public String getRateName() { return rateName; }
    public void setRateName(String rateName) { this.rateName = rateName; }
    public String getRateMinutes() { return rateMinutes; }
    public void setRateMinutes(String rateMinutes) { this.rateMinutes = rateMinutes; }
    public String getRatePrice() { return ratePrice; }
    public void setRatePrice(String ratePrice) { this.ratePrice = ratePrice; }
    public String getRatePreTaxPrice() { return ratePreTaxPrice; }
    public void setRatePreTaxPrice(String ratePreTaxPrice) { this.ratePreTaxPrice = ratePreTaxPrice; }

    @Override
    public String toString() {
        return "EventRates [externalName=" + externalName + ", internalName=" + internalName + ",rateGroupTitle=" + rateGroupTitle + ", rateLocation=" + rateLocation + ", rateName=" + rateName + ", rateMinutes=" + rateMinutes + ",ratePrice=" + ratePrice + ", ratePreTaxPrice=" + ratePreTaxPrice + "]";
    }
}

package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create cash deposit java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "cashDeposit")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CashDeposit implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bagNumber;
    private String pullDate;
    private String marketGroup;
    private String cdLocation;
    private String employeeName;
    private String shift;
    private String attachments;

    public String getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(String bagNumber) {
        this.bagNumber = bagNumber;
    }

    public String getPullDate() {
        return pullDate;
    }

    public void setPullDate(String pullDate) {
        this.pullDate = pullDate;
    }

    public String getMarketGroup() {
        return marketGroup;
    }

    public void setMarketGroup(String marketGroup) {
        this.marketGroup = marketGroup;
    }

    public String getCdLocation() {
        return cdLocation;
    }

    public void setCdLocation(String cdLocation) {
        this.cdLocation = cdLocation;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "CashDeposit [bagNumber=" + bagNumber + ", pullDate=" + pullDate + ",marketGroup=" + marketGroup + ", cdLocation=" + cdLocation + ", employeeName=" + employeeName + ", shift=" + shift + ", attachments=" + attachments + "]";
    }

}

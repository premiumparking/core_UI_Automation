package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create fees java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "fee")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String feeLocation;
    private String percentage;
    private String amount;

    public String getFeeLocation() {
        return feeLocation;
    }

    public void setFeeLocation(String feeLocation) {
        this.feeLocation = feeLocation;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fee [feeLocation=" + feeLocation + ", percentage=" + percentage + ", amount=" + amount + "]";
    }
}

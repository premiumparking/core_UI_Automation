package dataModel.OD;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create blackouts java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "blackout")
@XmlAccessorType(XmlAccessType.PROPERTY)

public class Blackout implements Serializable {
    private static final long serialVersionUID = 1L;

    private String market;
    private String blackoutName;
    private String blackoutStartTime;
    private String blackoutEndTime;
    private String blackoutLocation;

    public String getMarket() {  return market; }
    public void setMarket(String market) {  this.market = market; }
    public String getBlackoutName() { return blackoutName; }
    public void setBlackoutName(String blackoutName) { this.blackoutName = blackoutName; }
    public String getBlackoutStartTime() { return blackoutStartTime; }
    public void setBlackoutStartTime(String blackoutStartTime) { this.blackoutStartTime = blackoutStartTime; }
    public String getBlackoutEndTime() { return blackoutEndTime; }
    public void setBlackoutEndTime(String blackoutEndTime) { this.blackoutEndTime = blackoutEndTime; }
    public String getBlackoutLocation() { return blackoutLocation; }
    public void setBlackoutLocation(String blackoutLocation) { this.blackoutLocation = blackoutLocation; }

    @Override
    public String toString() {
        return "Blackout [market=" + market + ", blackoutName=" + blackoutName + ",blackoutStartTime=" + blackoutStartTime + ", blackoutEndTime=" + blackoutEndTime + ", blackoutLocation=" + blackoutLocation + "]";
    }
}

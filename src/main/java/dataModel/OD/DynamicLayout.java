package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to verify dynamic layouts java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "dynamicLayouts")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class DynamicLayout implements Serializable {

    private static final long serialVersionUID = 1L;

    private String BAName;

    public String getBAName() {  return BAName;    }

    public void setBAName(String BAName) {   this.BAName = BAName;    }

    @Override
    public String toString() {
        return "DynamicLayout [BAName=" + BAName + "]";
    }
}

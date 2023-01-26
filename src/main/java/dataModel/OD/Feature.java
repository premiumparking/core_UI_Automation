package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create feature java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "feature")
@XmlAccessorType(XmlAccessType.PROPERTY)

public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;

    private String featureIcon;
    private String featureTitle;
    private String featureDesc;
    private String featureUrl;

    public String getFeatureIcon() {
        return featureIcon;
    }

    public void setFeatureIcon(String featureIcon) {
        this.featureIcon = featureIcon;
    }

    public String getFeatureTitle() {
        return featureTitle;
    }

    public void setFeatureTitle(String featureTitle) {
        this.featureTitle = featureTitle;
    }

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    public String getFeatureUrl() {
        return featureUrl;
    }

    public void setFeatureUrl(String featureUrl) {
        this.featureUrl = featureUrl;
    }

    @Override
    public String toString() {
        return "Feature [featureIcon=" + featureIcon + ", featureTitle=" + featureTitle + ", featureDesc=" + featureDesc + ", featureUrl=" + featureUrl + "]";
    }
}

package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create GL Code java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "glCode")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class GLCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String productType;
    private String channelType;
    private String subChannelType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getSubChannelType() {
        return subChannelType;
    }

    public void setSubChannelType(String subChannelType) {
        this.subChannelType = subChannelType;
    }

    @Override
    public String toString() {
        return "GLCode [code=" + code + ", productType=" + productType + ", channelType=" + channelType + ", subChannelType=" + subChannelType + "]";
    }
}

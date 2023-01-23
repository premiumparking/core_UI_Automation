package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create client java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clientName;
    private String primaryAdmin;
    private String locations;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    public void setPrimaryAdmin(String primaryAdmin) {
        this.primaryAdmin = primaryAdmin;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Client [clientName=" + clientName + ", primaryAdmin=" + primaryAdmin + ", locations=" + locations + "]";
    }
}

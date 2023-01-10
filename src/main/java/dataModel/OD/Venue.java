package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create Venue java object
 * Data is getting loaded from XML File
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
@XmlRootElement(name = "venue")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Venue implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private String city;
    private String zip;
    private String latitude;
    private String longitude;
    private String phone;
    private String email;
    private String url;
    private String description;
    private String hours;
    private String metaTagTitle;
    private String metaTagDescription;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getHours() { return hours; }
    public void setHours(String hours) { this.hours = hours; }
    public String getMetaTagTitle() { return metaTagTitle; }
    public void setMetaTagTitle(String metaTagTitle) { this.metaTagTitle = metaTagTitle; }
    public String getMetaTagDescription() { return metaTagDescription; }
    public void setMetaTagDescription(String metaTagDescription) { this.metaTagDescription = metaTagDescription; }
}

package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create banner java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "banner")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bannerMarket;
    private String bannerStartsAt;
    private String bannerEndsAt;
    private String bannerPhoto;
    private String bannerTitle;
    private String bannerBody;

    public String getBannerMarket() {
        return bannerMarket;
    }

    public void setBannerMarket(String bannerMarket) {
        this.bannerMarket = bannerMarket;
    }

    public String getBannerStartsAt() {
        return bannerStartsAt;
    }

    public void setBannerStartsAt(String bannerStartsAt) {
        this.bannerStartsAt = bannerStartsAt;
    }

    public String getBannerEndsAt() {
        return bannerEndsAt;
    }

    public void setBannerEndsAt(String bannerEndsAt) {
        this.bannerEndsAt = bannerEndsAt;
    }

    public String getBannerPhoto() {
        return bannerPhoto;
    }

    public void setBannerPhoto(String bannerPhoto) {
        this.bannerPhoto = bannerPhoto;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerBody() {
        return bannerBody;
    }

    public void setBannerBody(String bannerBody) {
        this.bannerBody = bannerBody;
    }

    @Override
    public String toString() {
        return "Banner [bannerMarket=" + bannerMarket + ", bannerStartsAt=" + bannerStartsAt + ",bannerEndsAt=" + bannerEndsAt + ", bannerPhoto=" + bannerPhoto + ", bannerTitle=" + bannerTitle + ", bannerBody=" + bannerBody + "]";
    }
}

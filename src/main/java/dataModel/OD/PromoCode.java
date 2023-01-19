package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create promocode java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "promocode")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PromoCode implements Serializable {
    private static final long serialVersionUID = 1L;

    private String promoCode;
    private String amountOfUsers;
    private String discount;
    private String discountType;
    private String startsAt;
    private String endsAt;
    private String promoCodeNotes;

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getAmountOfUsers() {
        return amountOfUsers;
    }

    public void setAmountOfUsers(String amountOfUsers) {
        this.amountOfUsers = amountOfUsers;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public String getPromoCodeNotes() {
        return promoCodeNotes;
    }

    public void setPromoCodeNotes(String promoCodeNotes) {
        this.promoCodeNotes = promoCodeNotes;
    }

    @Override
    public String toString() {
        return "PromoCode [promoCode=" + promoCode + ", amountOfUsers=" + amountOfUsers + ",discount=" + discount + ", discountType=" + discountType + ", startsAt=" + startsAt + ", endsAt=" + endsAt + ",promoCodeNotes=" + promoCodeNotes + "]";
    }
}

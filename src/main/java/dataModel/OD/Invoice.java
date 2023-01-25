package dataModel.OD;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This model is to create invoice java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "invoice")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    private String invoicePayer;
    private String invoiceLocation;
    private String invoiceStartsAt;
    private String invoiceEndsAt;
    private String invoiceDollarAmount;
    private String invoiceNumber;

    public String getInvoicePayer() {
        return invoicePayer;
    }

    public void setInvoicePayer(String invoicePayer) {
        this.invoicePayer = invoicePayer;
    }

    public String getInvoiceLocation() {
        return invoiceLocation;
    }

    public void setInvoiceLocation(String invoiceLocation) {
        this.invoiceLocation = invoiceLocation;
    }

    public String getInvoiceStartsAt() {
        return invoiceStartsAt;
    }

    public void setInvoiceStartsAt(String invoiceStartsAt) {
        this.invoiceStartsAt = invoiceStartsAt;
    }

    public String getInvoiceEndsAt() {
        return invoiceEndsAt;
    }

    public void setInvoiceEndsAt(String invoiceEndsAt) {
        this.invoiceEndsAt = invoiceEndsAt;
    }

    public String getInvoiceDollarAmount() {
        return invoiceDollarAmount;
    }

    public void setInvoiceDollarAmount(String invoiceDollarAmount) {
        this.invoiceDollarAmount = invoiceDollarAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return "Invoice [invoicePayer=" + invoicePayer + ", invoiceLocation=" + invoiceLocation + ", invoiceStartsAt=" + invoiceStartsAt + ", invoiceEndsAt=" + invoiceEndsAt
                + ", invoiceDollarAmount=" + invoiceDollarAmount + ", invoiceNumber=" + invoiceNumber + "]";
    }
}

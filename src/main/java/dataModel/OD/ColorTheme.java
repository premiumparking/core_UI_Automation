package dataModel.OD;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/*
 * This model is to create color theme java object
 * Data is getting loaded from XML File
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
@XmlRootElement(name = "colorTheme")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ColorTheme implements Serializable {
    private static final long serialVersionUID = 1L;

    private String themeName;
    private String contentBoxBGColor;
    private String contentBoxTextColor;
    private String buttonsBGColor;
    private String buttonColor;

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getContentBoxBGColor() {
        return contentBoxBGColor;
    }

    public void setContentBoxBGColor(String contentBoxBGColor) {
        this.contentBoxBGColor = contentBoxBGColor;
    }

    public String getContentBoxTextColor() {
        return contentBoxTextColor;
    }

    public void setContentBoxTextColor(String contentBoxTextColor) {
        this.contentBoxTextColor = contentBoxTextColor;
    }

    public String getButtonsBGColor() {
        return buttonsBGColor;
    }

    public void setButtonsBGColor(String buttonsBGColor) {
        this.buttonsBGColor = buttonsBGColor;
    }

    public String getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(String buttonColor) {
        this.buttonColor = buttonColor;
    }

    @Override
    public String toString() {
        return "ColorTheme [themeName=" + themeName + ", contentBoxBGColor=" + contentBoxBGColor + ",contentBoxTextColor=" + contentBoxTextColor + ", buttonsBGColor=" + buttonsBGColor + ", buttonColor=" + buttonColor + "]";
    }
}

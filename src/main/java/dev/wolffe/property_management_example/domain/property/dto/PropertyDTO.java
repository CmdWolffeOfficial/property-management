package dev.wolffe.property_management_example.domain.property.dto;


import dev.wolffe.property_management_example.core.AlphabetHyphen.AlphabetHyphen;
import dev.wolffe.property_management_example.core.AlphabetNumb.AlphabetNumb;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;

public class PropertyDTO {

    @AlphabetHyphen
    private String propertyCanton;

    @AlphabetNumb
    private String propertyName;
    @Range(min = 500, max = 4500)
    private int propertyPrice;

    @Min(1)
    private int propertySize;

    @dev.wolffe.property_management_example.core.Url.Url
    private String propertyUrl;

    public String getPropertyCanton() {
        return propertyCanton;
    }

    public void setPropertyCanton(String propertyCanton) {
        this.propertyCanton = propertyCanton;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(int propertySize) {
        this.propertySize = propertySize;
    }

    public String getPropertyUrl() {
        return propertyUrl;
    }

    public void setPropertyUrl(String propertyUrl) {
        this.propertyUrl = propertyUrl;
    }
}


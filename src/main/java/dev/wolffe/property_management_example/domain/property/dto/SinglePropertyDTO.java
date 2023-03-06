package dev.wolffe.property_management_example.domain.property.dto;


import dev.wolffe.property_management_example.core.AlphabetHyphen.AlphabetHyphen;
import dev.wolffe.property_management_example.core.AlphabetNumb.AlphabetNumb;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;

public class SinglePropertyDTO {
    public static class Canton {
        @AlphabetHyphen
        private String propertyCanton;

        public String getCanton() {
            return propertyCanton;
        }

        public void setCanton(String propertyCanton) {
            this.propertyCanton = propertyCanton;
        }
    }


    public static class Name {
        @AlphabetNumb
        private String propertyName;

        public String getName() {
            return propertyName;
        }

        public void setName(String propertyName) {
            this.propertyName = propertyName;
        }
    }

    public static class Price {
        @Range(min = 500, max = 4500)
        private int propertyPrice;

        public int getPrice() {
            return propertyPrice;
        }

        public void setPrice(int propertyPrice) {
            this.propertyPrice = propertyPrice;
        }
    }

    public static class Size {
        @Min(1)
        private int propertySize;

        public int getSize() {
            return propertySize;
        }

        public void setSize(int propertySize) {
            this.propertySize = propertySize;
        }
    }

    public static class Url {
        @dev.wolffe.property_management_example.core.Url.Url
        private String propertyUrl;

        public String getUrl() {
            return propertyUrl;
        }

        public void setUrl(String propertyUrl) {
            propertyUrl = propertyUrl;
        }
    }
}


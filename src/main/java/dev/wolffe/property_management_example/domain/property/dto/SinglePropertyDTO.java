package dev.wolffe.property_management_example.domain.property.dto;


import dev.wolffe.property_management_example.core.AlphabetHyphen.AlphabetHyphen;
import dev.wolffe.property_management_example.core.AlphabetNumb.AlphabetNumb;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;

public class SinglePropertyDTO {
    public static class Canton {
        @AlphabetHyphen
        private String canton;

        public String getCanton() {
            return canton;
        }

        public void setCanton(String canton) {
            this.canton = canton;
        }
    }


    public static class Name {
        @AlphabetNumb
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Price {
        @Range(min = 500, max = 4500)
        private int price;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static class Size {
        @Min(1)
        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    public static class Url {
        @dev.wolffe.property_management_example.core.Url.Url
        private String Url;

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }
    }
}


package dev.wolffe.property_management_example.property;


import dev.wolffe.property_management_example.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "property_id")
    private UUID propertyId;


    @Column(name = "name")
    private String propertyName;

    @Column(name = "size")
    private int propertySize;

    @Column(name = "canton")
    private String propertyCanton;

    @Column(name = "url")
    private String propertyUrl;


    @Column(name = "price")
    private int propertyPrice;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User propertyAgent;

    public UUID getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(int propertySize) {
        this.propertySize = propertySize;
    }

    public String getPropertyCanton() {
        return propertyCanton;
    }

    public void setPropertyCanton(String propertyCanton) {
        this.propertyCanton = propertyCanton;
    }

    public String getPropertyUrl() {
        return propertyUrl;
    }

    public void setPropertyUrl(String propertyUrl) {
        this.propertyUrl = propertyUrl;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public User getPropertyAgent() {
        return propertyAgent;
    }

    public void setPropertyAgent(User propertyAgent) {
        this.propertyAgent = propertyAgent;
    }
}

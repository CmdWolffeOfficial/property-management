package dev.wolffe.property_management_example.domain.application;


import dev.wolffe.property_management_example.domain.property.Property;
import dev.wolffe.property_management_example.domain.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "application_id")
    private UUID applicationId;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property applicationProperty;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User applicationClient;

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Property getApplicationProperty() {
        return applicationProperty;
    }

    public void setApplicationProperty(Property applicationProperty) {
        this.applicationProperty = applicationProperty;
    }

    public User getApplicationClient() {
        return applicationClient;
    }

    public void setApplicationClient(User applicationClient) {
        this.applicationClient = applicationClient;
    }
}

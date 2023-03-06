package dev.wolffe.property_management_example.domain.user;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "username")
    private String userName;

    /*@ManyToOne
    @JoinColumn(name = "role_id")
    private Role userRole;*/


    public UUID getUserId() {
        return userId;
    }

    public void setUserIdd(UUID userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }*/
}


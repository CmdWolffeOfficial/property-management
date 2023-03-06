package dev.wolffe.property_management_example.domain.user;


import java.util.UUID;

public interface UserService {

    User addUser(User user);

    User findByName(String userName);

    User findByEmail(String userEmail);

    User findById(UUID userId);
}

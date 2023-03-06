package dev.wolffe.property_management_example.domain.user;


import dev.wolffe.property_management_example.domain.user.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User addUser(User user);

    User findByName(String userName);

    User findByEmail(String userEmail);

    User findById(UUID userId);

    List<User> findAll();
}

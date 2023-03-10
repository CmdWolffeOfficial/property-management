package dev.wolffe.property_management_example.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserEmailLike(String userEmail);

    User findByUserNameLike(String userName);
}

package dev.wolffe.property_management_example.domain.application;


import dev.wolffe.property_management_example.domain.property.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findAllByApplicationProperty(Property property);
}

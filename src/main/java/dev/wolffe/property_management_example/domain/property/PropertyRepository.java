package dev.wolffe.property_management_example.domain.property;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
    List<Property> findAllByPropertyCanton(String propertyCanton);

    Property findByPropertyNameLike(String propertyName);
}


package dev.wolffe.property_management_example.domain.property;


import java.util.List;
import java.util.UUID;

public interface PropertyService {


    Property addProperty(Property property, UUID userId);

    void deleteProperty(UUID id, UUID userId);

    Property updateProperty(UUID propertyId, UUID userId, Property property);

    List<Property> findAllByCanton(String propertyCanton);

    Property findByName(String propertyName);

    Property findById(UUID propertyId);

    Property updatePropertyCanton(UUID propertyId, UUID userId, String propertyCanton);

    Property updatePropertyName(UUID propertyId, UUID userId, String propertyName);

    Property updatePropertyPrice(UUID propertyId, UUID userId, int propertyPrice);

    Property updatePropertySize(UUID propertyId, UUID userId, int propertySize);

    Property updatePropertyUrl(UUID propertyId, UUID userId, String propertyUrl);


}


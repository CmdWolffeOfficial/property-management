package dev.wolffe.property_management_example.domain.property;


import dev.wolffe.property_management_example.domain.user.User;
import dev.wolffe.property_management_example.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final UserService userService;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.userService = userService;
    }


    @Override
    public List<Property> findAllByCanton(String propertyCanton) {
        return propertyRepository.findAllByPropertyCanton(propertyCanton);
    }

    @Override
    public Property findByName(String propertyName) {
        return propertyRepository.findByPropertyNameLike(propertyName);
    }


    @Override
    public void deleteProperty(UUID propertyId, UUID userId) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Optional<Property> optionalProperty = propertyRepository.findById(propertyId);
            if (optionalProperty.isPresent() && optionalProperty.get().getPropertyAgent().equals(user)) {
                propertyRepository.deleteById(propertyId);
            }
        }
    }

    @Override
    public Property addProperty(Property property, UUID userId) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            property.setPropertyAgent(user);
            return propertyRepository.save(property);
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }


    @Override
    public Property updateProperty(UUID propertyId, UUID userId, Property newProperty) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Property property = findPropertyById(propertyId);
            if (property.getPropertyAgent().equals(user)) {
                newProperty.setPropertyId(property.getPropertyId());
                newProperty.setPropertyAgent(property.getPropertyAgent());
                return propertyRepository.save(newProperty);
            }
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Property findById(UUID propertyId) {
        Optional<Property> optionalProperty = propertyRepository.findById(propertyId);
        if (optionalProperty.isPresent()) {
            return optionalProperty.get();
        }
        throw new NoSuchElementException("No property with id " + propertyId + " found");
    }

    @Override
    public Property updatePropertyCanton(UUID propertyId, UUID userId, String propertyCanton) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Property property = findById(propertyId);
            if (property.getPropertyAgent().equals(user)) {
                property.setPropertyCanton(propertyCanton);
                return propertyRepository.save(property);
            }
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Property updatePropertyName(UUID propertyId, UUID userId, String propertyName) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Property property = findById(propertyId);
            if (property.getPropertyAgent().equals(user)) {
                property.setPropertyName(propertyName);
                return propertyRepository.save(property);
            }
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Property updatePropertyPrice(UUID propertyId, UUID userId, int propertyPrice) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Property property = findById(propertyId);
            if (property.getPropertyAgent().equals(user)) {
                property.setPropertyPrice(propertyPrice);
                return propertyRepository.save(property);
            }
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Property updatePropertySize(UUID propertyId, UUID userId, int propertySize) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Property property = findById(propertyId);
            if (property.getPropertyAgent().equals(user)) {
                property.setPropertySize(propertySize);
                return propertyRepository.save(property);
            }
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Property updatePropertyUrl(UUID propertyId, UUID userId, String propertyUrl) {
        User user = userService.findById(userId);
        if (user.getUserRole().getRoleName().equals("Agent")) {
            Property property = findById(propertyId);
            if (property.getPropertyAgent().equals(user)) {
                property.setPropertyUrl(propertyUrl);
                return propertyRepository.save(property);
            }
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }


}

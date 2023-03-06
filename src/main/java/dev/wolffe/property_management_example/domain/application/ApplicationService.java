package dev.wolffe.property_management_example.domain.application;


import java.util.UUID;

public interface ApplicationService {

    Application acceptApplication(UUID userId, UUID applicationId);


    Application createApplication(UUID userId, UUID propertyId);

    Application denyApplication(UUID userId, UUID applicationId);


    Application findById(UUID id);


}


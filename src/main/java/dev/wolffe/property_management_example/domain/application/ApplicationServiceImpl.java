package dev.wolffe.property_management_example.domain.application;


import dev.wolffe.property_management_example.domain.property.Property;
import dev.wolffe.property_management_example.domain.property.PropertyService;
import dev.wolffe.property_management_example.domain.user.User;
import dev.wolffe.property_management_example.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationServiceImpl implements ApplicationService {


    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PropertyService propertyService;


    @Override
    public Application acceptApplication(UUID userId, UUID applicationId) {
        User user = userService.findById(userId);
        Application currentApplication = findById(applicationId);
        if (user.getUserRole().getRoleName().equals("Agent") && currentApplication.getApplicationProperty().getPropertyAgent().equals(user)) {
            for (Application application : applicationRepository.findAllByApplicationProperty(currentApplication.getApplicationProperty())) {
                application.setApplicationStatus(ApplicationStatus.DENIED);
                applicationRepository.save(application);
            }
            currentApplication.setApplicationStatus(ApplicationStatus.ACCEPTED);
            applicationRepository.save(currentApplication);
            return currentApplication;
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Application createApplication(UUID userId, UUID propertyId) {
        User user = userService.findById(userId);
        Property property = propertyService.findById(propertyId);
        boolean multipleApplications = false;
        for (Application application : applicationRepository.findAllByApplicationProperty(property)) {
            multipleApplications = application.getApplicationClient().equals(user);
        }
        if (user.getUserRole().getRoleName().equals("Client") && !multipleApplications) {
            Application application = new Application();
            application.setApplicationClient(user);
            application.setApplicationProperty(property);
            application.setApplicationStatus(ApplicationStatus.PENDING);
            return applicationRepository.save(application);
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }


    @Override
    public Application denyApplication(UUID userId, UUID applicationId) {
        User user = userService.findById(userId);
        Application application = findById(applicationId);
        if (user.getUserRole().getRoleName().equals("Agent") && application.getApplicationProperty().getPropertyAgent().equals(user)) {
            application.setApplicationStatus(ApplicationStatus.DENIED);
            return applicationRepository.save(application);
        }
        throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Application findById(UUID applicationId) {
        Optional<Application> applicationOptional = applicationRepository.findById(applicationId);
        if (applicationOptional.isPresent()) {
            return applicationOptional.get();
        }
        throw new NoSuchElementException("No application with id " + applicationId + " found");
    }


}

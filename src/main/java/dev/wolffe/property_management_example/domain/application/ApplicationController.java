package dev.wolffe.property_management_example.domain.application;


import dev.wolffe.property_management_example.domain.application.dto.ApplicationDTO;
import dev.wolffe.property_management_example.domain.application.dto.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationMapper applicationMapper;


    @PostMapping("/apply/{propertyId}/user/{userId}")
    public ResponseEntity<ApplicationDTO> createApplication(@PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationMapper.toDTO(applicationService.createApplication(userId, propertyId)));
    }


    @PatchMapping("/accept/{applicationId}/user/{userId}")
    public ResponseEntity<ApplicationDTO> acceptApplication(@PathVariable("applicationId") UUID applicationId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationMapper.toDTO(applicationService.acceptApplication(userId, applicationId)));
    }


    @PatchMapping("/deny/{applicationId}/user/{userId}")
    public ResponseEntity<ApplicationDTO> denyApplication(@PathVariable("applicationId") UUID applicationId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationMapper.toDTO(applicationService.denyApplication(userId, applicationId)));
    }
}

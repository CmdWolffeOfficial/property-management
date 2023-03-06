package dev.wolffe.property_management_example.domain.property;


import dev.wolffe.property_management_example.domain.property.dto.PropertyDTO;
import dev.wolffe.property_management_example.domain.property.dto.PropertyMapper;
import dev.wolffe.property_management_example.domain.property.dto.SinglePropertyDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyMapper propertyMapper;

    @PostMapping("/user/{userId}")
    public ResponseEntity<PropertyDTO> addProperty(@Valid @RequestBody PropertyDTO propertyDTO, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyMapper.toDTO(propertyService.addProperty(propertyMapper.fromDTO(propertyDTO), userId)));
    }

    @GetMapping("/canton")
    public ResponseEntity<List<PropertyDTO>> findPropertiesByCanton(@RequestParam("canton") String propertyCanton) {
        return ResponseEntity.ok(propertyMapper.allToDTO(propertyService.findAllByCanton(propertyCanton)));
    }


    @GetMapping("/name")
    public ResponseEntity<PropertyDTO> findPropertyByName(@RequestParam("name") String propertyName) {
        return ResponseEntity.ok(propertyMapper.toDTO(propertyService.findByName(propertyName)));
    }


    @PutMapping("/{propertyId}/user/{userId}")
    public ResponseEntity<PropertyDTO> updateProperty(@PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId, @Valid @RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyMapper.toDTO(propertyService.updateProperty(propertyId, userId, propertyMapper.fromDTO(propertyDTO))));
    }


    @DeleteMapping("/{propertyId}/user/{userId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        propertyService.deleteProperty(propertyId, userId);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{propertyId}/canton/user/{userId}")
    public ResponseEntity<PropertyDTO> updatePropertyCanton(@Valid @RequestBody SinglePropertyDTO.Canton propertyDTO, @PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(propertyMapper.toDTO(propertyService.updatePropertyCanton(propertyId, userId, propertyDTO.getCanton())));
    }


    @PatchMapping("/{propertyId}/name/user/{userId}")
    public ResponseEntity<PropertyDTO> updatePropertyName(@Valid @RequestBody SinglePropertyDTO.Name propertyDTO, @PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(propertyMapper.toDTO(propertyService.updatePropertyName(propertyId, userId, propertyDTO.getName())));
    }


    @PatchMapping("/{propertyId}/price/user/{userId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@Valid @RequestBody SinglePropertyDTO.Price propertyDTO, @PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(propertyMapper.toDTO(propertyService.updatePropertyPrice(propertyId, userId, propertyDTO.getPrice())));
    }

    @PatchMapping("/{propertyId}/size/user/{userId}")
    public ResponseEntity<PropertyDTO> updatePropertySize(@Valid @RequestBody SinglePropertyDTO.Size propertyDTO, @PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(propertyMapper.toDTO(propertyService.updatePropertySize(propertyId, userId, propertyDTO.getSize())));
    }


    @PatchMapping("/{propertyId}/url/user/{userId}")
    public ResponseEntity<PropertyDTO> updatePropertyUrl(@Valid @RequestBody SinglePropertyDTO.Url propertyDTO, @PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(propertyMapper.toDTO(propertyService.updatePropertyUrl(propertyId, userId, propertyDTO.getUrl())));
    }


}

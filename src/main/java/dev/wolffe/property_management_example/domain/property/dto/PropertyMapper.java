package dev.wolffe.property_management_example.domain.property.dto;


import dev.wolffe.property_management_example.domain.property.Property;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PropertyMapper {
    PropertyDTO toDTO(Property property);

    Property fromDTO(PropertyDTO propertyDTO);

    List<PropertyDTO> allToDTO(List<Property> properties);


}

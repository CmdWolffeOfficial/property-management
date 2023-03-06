package dev.wolffe.property_management_example.domain.application.dto;


import dev.wolffe.property_management_example.domain.application.Application;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationDTO toDTO(Application application);

    Application fromDTO(ApplicationDTO applicationDTO);


}

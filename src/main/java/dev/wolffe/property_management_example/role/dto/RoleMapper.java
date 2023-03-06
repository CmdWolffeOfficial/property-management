package dev.wolffe.property_management_example.role.dto;


import dev.wolffe.property_management_example.role.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDTO(RoleDTO roleDTO);

    RoleDTO toDTO(Role role);
}


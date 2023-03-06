package dev.wolffe.property_management_example.domain.user.dto;


import dev.wolffe.property_management_example.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    User fromDTO(UserDTO dto);


}


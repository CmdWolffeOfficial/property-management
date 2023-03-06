package dev.wolffe.property_management_example.domain.role;


public interface RoleService {

    Role addRole(Role role);

    Role findByName(String roleName);

}


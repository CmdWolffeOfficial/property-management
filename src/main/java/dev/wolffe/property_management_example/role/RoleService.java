package dev.wolffe.property_management_example.role;


public interface RoleService {

    Role addRole(Role role);

    Role findByName(String roleName);

}


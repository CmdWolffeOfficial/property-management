package dev.wolffe.property_management_example.domain.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByName(String roleName) {
        Optional<Role> optionalRole = roleRepository.findAllByRoleName(roleName);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }
        throw new NoSuchElementException("No role found with name " + roleName);
    }
}

package dev.wolffe.property_management_example.role;


import dev.wolffe.property_management_example.role.dto.RoleDTO;
import dev.wolffe.property_management_example.role.dto.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;


    @PostMapping("")
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleMapper.toDTO(roleService.addRole(roleMapper.fromDTO(roleDTO))));
    }
}


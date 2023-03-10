package dev.wolffe.property_management_example.domain.user;


import dev.wolffe.property_management_example.domain.user.dto.UserDTO;
import dev.wolffe.property_management_example.domain.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    @PostMapping("")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDTO(userService.addUser(userMapper.fromDTO(userDTO))));
    }

    @GetMapping("/name")
    public ResponseEntity<UserDTO> findUserByName(@RequestParam("username") String userName) {
        return ResponseEntity.ok(userMapper.toDTO(userService.findByName(userName)));
    }

    @GetMapping("/email")
    public ResponseEntity<UserDTO> findUserByEmail(@RequestParam("email") String userEmail) {
        return ResponseEntity.ok(userMapper.toDTO(userService.findByEmail(userEmail)));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }




}


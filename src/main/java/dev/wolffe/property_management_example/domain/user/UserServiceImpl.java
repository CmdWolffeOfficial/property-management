package dev.wolffe.property_management_example.domain.user;


import dev.wolffe.property_management_example.domain.role.RoleService;
import dev.wolffe.property_management_example.domain.user.dto.UserDTO;
import dev.wolffe.property_management_example.domain.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    public User addUser(User user) {
        if (user.getUserEmail().matches("(.)*@wolffe.dev")) {
            user.setUserRole(roleService.findByName("Agent"));
        } else {
            user.setUserRole(roleService.findByName("Client"));
        }
        return userRepository.save(user);
    }

    @Override
    public User findByName(String userName) {
        return userRepository.findByUserNameLike(userName);
    }

    @Override
    public User findByEmail(String userEmail) {
        return userRepository.findByUserNameLike(userEmail);
    }

    @Override
    public User findById(UUID userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new NoSuchElementException("No user with id " + userId + " found");
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}

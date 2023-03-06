package dev.wolffe.property_management_example.domain.user;


import dev.wolffe.property_management_example.domain.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;



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



}

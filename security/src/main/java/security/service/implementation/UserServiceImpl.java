package security.service.implementation;

import org.springframework.stereotype.Service;
import security.model.User;
import security.model.UserRole;
import security.repository.RoleRepository;
import security.repository.UserRepository;
import security.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            System.out.println("User already exists");
            throw new Exception("User exists");
        }
        else {
            for (UserRole userRole: userRoles) {
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}

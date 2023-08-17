package security.service;

import org.springframework.stereotype.Service;
import security.model.User;
import security.model.UserRole;
import security.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User saveUser(User user, Set<UserRole> userRoles) {
        return userRepository.save(user);
    }
}

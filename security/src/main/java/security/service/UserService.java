package security.service;

import security.model.User;
import security.model.UserRole;

import java.util.Set;

public interface UserService {

    User save(User user, Set<UserRole> userRoles) throws Exception;

    User findByUsername(String username);

    void delete(User user);

}

package security.controller;


import org.springframework.web.bind.annotation.*;
import security.model.Role;
import security.model.User;
import security.model.UserRole;
import security.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(2);
        role.setName("CUSTOMER");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return userService.save(user, roles);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String email) {
        return userService.findByUsername(email);
    }

    @DeleteMapping("/{email}")
    public void deleteUserByEmail(@PathVariable("email") String username) {
        User user = userService.findByUsername(username);
        userService.delete(user);
    }




}

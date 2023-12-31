package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

    User findByUsername(String username);
}
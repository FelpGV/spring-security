package security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import security.model.Role;

public interface RolRepository extends JpaRepository<Role, Long>{
}

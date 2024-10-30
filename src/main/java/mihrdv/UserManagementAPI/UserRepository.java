package mihrdv.UserManagementAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find the user by email, now returning Optional
    Optional<User> findByEmail(String email);

    // Custom method to find the user by username, now returning Optional
    Optional<User> findByUsername(String username);

    // Custom method to find the user by username and email
    Optional<User> findByUsernameAndEmail(String username, String email);
}

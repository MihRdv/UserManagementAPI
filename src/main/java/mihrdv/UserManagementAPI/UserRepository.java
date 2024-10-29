package mihrdv.UserManagementAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Custom method to find the users by their email
    public User findByEmail(String email);

}

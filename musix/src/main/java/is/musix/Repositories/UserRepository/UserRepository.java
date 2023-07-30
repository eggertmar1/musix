package is.musix.Repositories.UserRepository;

import is.musix.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods, if needed
    User findByUsernameAndPassword(String username, String password);
}
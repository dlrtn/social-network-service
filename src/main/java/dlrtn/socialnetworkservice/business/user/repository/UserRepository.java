package dlrtn.socialnetworkservice.business.user.repository;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    boolean existsByUsername(String username);

    void insertUser(User user);

}

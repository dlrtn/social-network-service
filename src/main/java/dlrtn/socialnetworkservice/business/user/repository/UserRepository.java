package dlrtn.socialnetworkservice.business.user.repository;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    Boolean existsByUsername(String username);

    void save(User user);

}

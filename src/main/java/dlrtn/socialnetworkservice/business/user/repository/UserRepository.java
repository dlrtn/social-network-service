package dlrtn.socialnetworkservice.business.user.repository;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    //todo Repository interface 변경
    boolean existsByUsername(String username);

}

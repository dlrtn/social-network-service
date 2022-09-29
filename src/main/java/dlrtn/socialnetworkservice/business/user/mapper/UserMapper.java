package dlrtn.socialnetworkservice.business.user.mapper;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void save(User user);

    boolean existsByUsername(String username);

    User findByUsername(String username);

}

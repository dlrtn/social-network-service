package dlrtn.sns.business.user.infrastructure;

import dlrtn.sns.business.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserJpaRepository userJpaRepository;

    public User saveUser(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toDomain();
    }

}

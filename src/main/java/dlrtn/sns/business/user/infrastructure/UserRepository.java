package dlrtn.sns.business.user.infrastructure;

import dlrtn.sns.business.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserJpaRepository userJpaRepository;

    public User save(User user) {
        return userJpaRepository.save(UserEntity.from(user)).toDomain();
    }

    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

}

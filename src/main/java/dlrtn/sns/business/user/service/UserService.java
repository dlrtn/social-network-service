package dlrtn.sns.business.user.service;

import dlrtn.sns.business.user.domain.User;
import dlrtn.sns.business.user.domain.UserRole;
import dlrtn.sns.business.user.domain.request.CreateUserRequest;
import dlrtn.sns.business.user.infrastructure.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(CreateUserRequest request) {
        User user = User.builder()
                .id("1")
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .role(UserRole.USER)
                .build();

        return userRepository.saveUser(user);
    }


}

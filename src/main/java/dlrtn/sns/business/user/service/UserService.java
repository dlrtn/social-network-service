package dlrtn.sns.business.user.service;

import dlrtn.sns.business.user.domain.User;
import dlrtn.sns.business.user.domain.exception.UserAlreadyExistsException;
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
    public User create(CreateUserRequest request) {
        boolean emailExists = userRepository.existsByEmail(request.getEmail());
        UserAlreadyExistsException.checkAndThrow(emailExists);

        User user = User.fromCreateRequest(request);
        return userRepository.save(user);
    }

}

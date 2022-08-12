package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.exception.AlreadyExistsUserIdException;
import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.*;
import dlrtn.socialnetworkservice.business.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AlreadyExistsUserIdException();
        }
        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .createdAt(now)
                .updatedAt(now)
                .build();

        userRepository.save(user);
        return SignUpResponse.success();
    }

    public SignInResponse signIn(SignInRequest request) {
        return SignInResponse.success();
    }

    public SignOutResponse signOut(SignOutRequest request) {
        return SignOutResponse.success();
    }

}

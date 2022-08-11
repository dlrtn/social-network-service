package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpResponse;
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
            //todo throw Exception
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

}

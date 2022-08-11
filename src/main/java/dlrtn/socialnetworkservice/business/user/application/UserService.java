package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.model.UserType;
import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;
import dlrtn.socialnetworkservice.business.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;

    public ResponseEntity signUp(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new Exception();
        }LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .userType(UserType.USER)
                .createdAt(now)
                .updatedAt(now)
                .build();

        userRepository.save(user);

    }

}

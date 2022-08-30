package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpResponse;
import dlrtn.socialnetworkservice.business.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        if (userMapper.existsByUsername(request.getUsername())) {
            log.info("User id already exists, user id : " + request.getUsername());
            return SignUpResponse.failWith("The user id already exists");
        }
        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .createdAt(now)
                .updatedAt(now)
                .build();
        userMapper.save(user);

        return SignUpResponse.success();
    }

}

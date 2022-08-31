package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.exception.AlreadyExistsUserIdException;
import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.*;
import dlrtn.socialnetworkservice.business.user.repository.UserRepository;
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
            log.error("SignUp request failed : Username already exists, username : " + request.getUsername());
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

    public SignInResponse signIn(SignInRequest request) {
        return SignInResponse.success();
    }

    public SignOutResponse signOut(SignOutRequest request) {
        return SignOutResponse.success();
    }

}

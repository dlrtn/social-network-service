package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.mapper.UserMapper;
import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.*;
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
    public RegisterResponse signUp(RegisterRequest request) {
        if (userMapper.existsByUsername(request.getUsername())) {
            log.error("SignUp request failed : Username already exists, username : " + request.getUsername());
            return RegisterResponse.failWith("The user id already exists");
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

        return RegisterResponse.success();
    }

    public SignInResponse signIn(SignInRequest request) {
        return SignInResponse.success();
    }

    public LogOutResponse logOut(LogOutRequest request) {
        return LogOutResponse.success();
    }

}

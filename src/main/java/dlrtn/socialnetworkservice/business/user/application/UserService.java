package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.exception.AlreadyExistsUserIdException;
import dlrtn.socialnetworkservice.business.user.exception.UserAuthenticationException;
import dlrtn.socialnetworkservice.business.user.model.domain.User;
import dlrtn.socialnetworkservice.business.user.model.payload.*;
import dlrtn.socialnetworkservice.business.user.repository.UserRepository;
import dlrtn.socialnetworkservice.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AlreadyExistsUserIdException();
        }
        LocalDateTime now = LocalDateTime.now();

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .createdAt(now)
                .updatedAt(now)
                .build();

        userRepository.save(user);
        return SignUpResponse.success();
    }

    public SignInResponse signIn(SignInRequest request) {
        User foundUser = userRepository.findByUsername(request.getUsername());
        if (ObjectUtils.isEmpty(foundUser) || !passwordEncoder.matches(request.getPassword(), foundUser.getUsername())) {
            throw new UserAuthenticationException();
        }

        String jwtToken = jwtTokenProvider.createToken(foundUser.getUsername(), foundUser.getUserType());

        return SignInResponse.success(jwtToken);
    }

    public SignOutResponse signOut(SignOutRequest request) {
        return SignOutResponse.success();
    }

}

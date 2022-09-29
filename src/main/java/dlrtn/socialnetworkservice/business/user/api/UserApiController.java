package dlrtn.socialnetworkservice.business.user.api;

import dlrtn.socialnetworkservice.business.user.application.UserService;
import dlrtn.socialnetworkservice.business.user.model.payload.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        return userService.signUp(request);
    }

    @PostMapping("/sign-in")
    public SignInResponse signIn(@RequestBody SignInRequest request) {
        return userService.signIn(request);
    }

    @PostMapping("/log-out")
    public LogOutResponse logOut(@RequestBody LogOutRequest request) {
        return userService.logOut(request);
    }

}

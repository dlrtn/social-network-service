package dlrtn.socialnetworkservice.business.user.api;

import dlrtn.socialnetworkservice.business.user.application.UserService;
import dlrtn.socialnetworkservice.business.user.model.payload.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {
        return userService.signUp(request);
    }

    @PostMapping("/sign-in")
    public SignInResponse signIn(@RequestBody SignInRequest request) {
        return userService.signIn(request);
    }

    @PostMapping("/sign-out")
    public SignOutResponse signOut(@RequestBody SignOutRequest request) {
        return userService.signOut(request);
    }

}

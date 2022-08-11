package dlrtn.socialnetworkservice.business.user.api;

import dlrtn.socialnetworkservice.business.user.application.UserService;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    UserService userService;

    @PostMapping("/signup")
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {
        return userService.signUp(request);
    }

}

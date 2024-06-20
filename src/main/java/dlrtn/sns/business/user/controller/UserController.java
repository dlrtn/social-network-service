package dlrtn.sns.business.user.controller;

import dlrtn.sns.business.user.domain.User;
import dlrtn.sns.business.user.domain.request.CreateUserRequest;
import dlrtn.sns.business.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "users", description = "사용자 관리 API")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public User create(@RequestBody CreateUserRequest request) {
        return userService.save(request);
    }

}

package dlrtn.sns.business.user.controller;

import dlrtn.sns.business.user.domain.User;
import dlrtn.sns.business.user.domain.request.CreateUserRequest;
import dlrtn.sns.business.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String getUsers() {
        return "users";
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserRequest request) {
        return userService.save(request);
    }

}

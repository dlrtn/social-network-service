package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.common.UserTestsConstants;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void signUpTest() {
        SignUpRequest request = UserTestsConstants.TEST_SIGN_UP_REQUEST;

        SignUpResponse response = userService.signUp(request);

        Assertions.assertEquals("User sign up success", response.getDescription());
    }

    @Test
    public void duplicateUserTest() {
        SignUpRequest request = UserTestsConstants.TEST_SIGN_UP_REQUEST;

        SignUpResponse response = userService.signUp(request);
        SignUpResponse secondResponse = userService.signUp(request);

        Assertions.assertEquals("The user id already exists", secondResponse.getDescription());
    }

}

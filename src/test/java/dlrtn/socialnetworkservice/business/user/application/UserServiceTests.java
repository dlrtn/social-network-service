package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.common.UserTestsConstants;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;
import dlrtn.socialnetworkservice.business.user.model.payload.SignUpResponse;
import dlrtn.socialnetworkservice.business.user.repository.UserRepository;
import dlrtn.socialnetworkservice.common.model.ResponseMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService userService;

    @Test
    public void UserSignUpTest() {
        SignUpRequest request = UserTestsConstants.TEST_SIGN_UP_REQUEST;

        SignUpResponse response = userService.signUp(request);

        Assertions.assertEquals(ResponseMessage.SUCCESS, response.getMessage());
    }

}

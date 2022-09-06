package dlrtn.socialnetworkservice.business.user.application;

import dlrtn.socialnetworkservice.business.user.common.UserTestsConstants;
import dlrtn.socialnetworkservice.business.user.model.payload.RegisterRequest;
import dlrtn.socialnetworkservice.business.user.model.payload.RegisterResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("사용자 회원가입 테스트")
    void signUpTest() {
        RegisterRequest request = UserTestsConstants.TEST_SIGN_UP_REQUEST;

        RegisterResponse response = userService.signUp(request);

        Assertions.assertEquals("User sign up success", response.getDescription());
    }

    @Test
    @DisplayName("사용자 중복 회원가입 방지 테스트")
    void userSignUpDuplicateExceptionTest() {
        RegisterRequest request = UserTestsConstants.TEST_SIGN_UP_REQUEST;

        RegisterResponse response = userService.signUp(request);
        RegisterResponse secondResponse = userService.signUp(request);

        Assertions.assertEquals("The user id already exists", secondResponse.getDescription());
    }

}

package dlrtn.socialnetworkservice.business.user.common;

import dlrtn.socialnetworkservice.business.user.model.payload.SignUpRequest;

public class UserTestsConstants {

    private static final String TEST_USERNAME = "1234";

    private static final String TEST_PASSWORD = "1234";

    private static final String TEST_EMAIL = "1@1";

    public static final SignUpRequest TEST_SIGN_UP_REQUEST = SignUpRequest.builder()
            .username(TEST_USERNAME)
            .password(TEST_PASSWORD)
            .email(TEST_EMAIL)
            .build();

}

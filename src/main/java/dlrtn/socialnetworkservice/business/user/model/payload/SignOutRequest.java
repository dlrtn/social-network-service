package dlrtn.socialnetworkservice.business.user.model.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignOutRequest {

    private final String username;

    private final String password;

    private final String email;

}

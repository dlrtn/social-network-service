package dlrtn.sns.business.user.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserRequest {

    private final String email;

    private final String password;

    private final String name;

}

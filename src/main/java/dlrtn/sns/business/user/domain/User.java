package dlrtn.sns.business.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private String id;

    private String email;

    private String password;

    private String name;

    private UserRole role;


}

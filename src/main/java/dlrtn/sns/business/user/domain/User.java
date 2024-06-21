package dlrtn.sns.business.user.domain;

import dlrtn.sns.business.user.domain.request.CreateUserRequest;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private UUID id;

    private String email;

    private String password;

    private String name;

    private UserRole role;

    public static User fromCreateRequest(CreateUserRequest request) {
        return User.builder()
                .id(UUID.randomUUID())
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .role(UserRole.USER)
                .build();
    }

}

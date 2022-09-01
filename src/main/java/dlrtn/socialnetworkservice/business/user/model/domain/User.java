package dlrtn.socialnetworkservice.business.user.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private UserType userType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

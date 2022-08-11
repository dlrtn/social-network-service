package dlrtn.socialnetworkservice.business.user.model.domain;

import dlrtn.socialnetworkservice.business.user.model.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Builder(toBuilder = true)
@ToString
public class User {

    @Id
    @Column(name = "userId")
    private final Long id;

    @Column(name = "username")
    private final String username;

    @Column(name = "password")
    private final String password;

    @Column(name = "email")
    private final String email;

    @Column(name = "userType")
    private final UserType userType;

    @Column(name = "createdAt")
    private final LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private final LocalDateTime updatedAt;

}

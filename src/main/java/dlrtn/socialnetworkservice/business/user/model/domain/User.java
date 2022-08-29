package dlrtn.socialnetworkservice.business.user.model.domain;

import dlrtn.socialnetworkservice.business.user.model.UserType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "User")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private UserType userType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public User(String username, String password, String email, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = UserType.USER;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

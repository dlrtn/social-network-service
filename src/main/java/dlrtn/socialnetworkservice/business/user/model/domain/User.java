package dlrtn.socialnetworkservice.business.user.model.domain;

import dlrtn.socialnetworkservice.business.user.model.UserType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
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

package dlrtn.sns.business.user.infrastructure;

import dlrtn.sns.business.user.domain.User;
import dlrtn.sns.business.user.domain.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    public UserEntity(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.role = user.getRole();
    }

    public static UserEntity from(User user) {
        return new UserEntity(user);
    }

    public User toDomain() {
        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }
}

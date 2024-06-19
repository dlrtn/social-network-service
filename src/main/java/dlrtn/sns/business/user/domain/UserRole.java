package dlrtn.sns.business.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN("관리자 권한"),
    USER("사용자 권한");

    private final String description;
}

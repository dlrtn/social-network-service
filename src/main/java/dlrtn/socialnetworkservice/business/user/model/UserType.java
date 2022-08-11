package dlrtn.socialnetworkservice.business.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {

    USER("유저 권한"),
    ADMIN("어드민 권한"),
    ;

    private final String description;

}

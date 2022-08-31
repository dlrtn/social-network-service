package dlrtn.socialnetworkservice.business.user.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {

    USER("유저 권한(게시글 작성, 수정 등)"),
    ADMIN("어드민 권한(게시글 삭제, 유저 탈퇴 등)"),
    ;

    private final String description;

}

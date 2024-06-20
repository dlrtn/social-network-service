package dlrtn.sns.business.user.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserRequest {

    @Schema(description = "사용자 이메일", example = "test@test.com")
    @Email
    private final String email;

    @Schema(description = "사용자 비밀번호", example = "password")
    private final String password;

    @Schema(description = "사용자 이름", example = "홍길동")
    private final String name;

    @Schema(description = "사용자 전화번호", example = "010-1234-5678")
    private final String phoneNumber;

}

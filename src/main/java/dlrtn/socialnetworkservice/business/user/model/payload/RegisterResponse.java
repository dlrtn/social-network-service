package dlrtn.socialnetworkservice.business.user.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class RegisterResponse {

    private final boolean success;

    private final String description;

    public static RegisterResponse success() {
        return successWith("User sign up success");
    }

    public static RegisterResponse failWith(String description) {
        return of(false, description);
    }

    public static RegisterResponse successWith(String description) {
        return of(true, description);
    }

}

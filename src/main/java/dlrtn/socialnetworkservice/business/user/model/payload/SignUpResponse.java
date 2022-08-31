package dlrtn.socialnetworkservice.business.user.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class SignUpResponse {

    private final boolean success;

    private final String description;

    public static SignUpResponse success() {
        return successWith("User sign up success");
    }

    public static SignUpResponse failWith(String description) {
        return of(false, description);
    }

    public static SignUpResponse successWith(String description) {
        return of(true, description);
    }

}

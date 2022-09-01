package dlrtn.socialnetworkservice.business.user.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class SignInResponse {

    private final boolean success;

    private final String description;

    public static SignInResponse success() {
        return successWith("User sign in success");
    }

    public static SignInResponse failWith(String description) {
        return of(false, description);
    }

    public static SignInResponse successWith(String description) {
        return of(true, description);
    }

}

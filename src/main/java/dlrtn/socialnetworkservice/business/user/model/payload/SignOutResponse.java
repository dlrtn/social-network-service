package dlrtn.socialnetworkservice.business.user.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class SignOutResponse {

    private final boolean success;

    private final String description;

    public static SignOutResponse success() {
        return successWith("User sign out success");
    }

    public static SignOutResponse failWith(String description) {
        return of(false, description);
    }

    public static SignOutResponse successWith(String description) {
        return of(true, description);
    }

}

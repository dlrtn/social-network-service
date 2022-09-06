package dlrtn.socialnetworkservice.business.user.model.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class LogOutResponse {

    private final boolean success;

    private final String description;

    public static LogOutResponse success() {
        return successWith("User sign out success");
    }

    public static LogOutResponse failWith(String description) {
        return of(false, description);
    }

    public static LogOutResponse successWith(String description) {
        return of(true, description);
    }

}

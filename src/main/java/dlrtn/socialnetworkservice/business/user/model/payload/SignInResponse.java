package dlrtn.socialnetworkservice.business.user.model.payload;

import dlrtn.socialnetworkservice.common.model.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(staticName = "of")
@ToString
public class SignInResponse {

    private final boolean success;

    private final ResponseMessage message;

    private final String description;

    private final String jwt;

    public static SignInResponse success(String jwt) {
        return successWith(ResponseMessage.SUCCESS, jwt);
    }

    public static SignInResponse failWith(ResponseMessage message) {
        return of(false, message, message.getDescription(), null);
    }

    public static SignInResponse successWith(ResponseMessage message, String jwt) {
        return of(true, message, message.getDescription(), jwt);
    }

}

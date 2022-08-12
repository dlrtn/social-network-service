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

    public static SignInResponse success() {
        return successWith(ResponseMessage.SUCCESS);
    }

    public static SignInResponse failWith(ResponseMessage message) {
        return of(false, message, message.getDescription());
    }

    public static SignInResponse successWith(ResponseMessage message) {
        return of(true, message, message.getDescription());
    }

}

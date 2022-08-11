package dlrtn.socialnetworkservice.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    SUCCESS("Success"),
    SERVER_ERROR("Failed by server error");

    private final String description;

}

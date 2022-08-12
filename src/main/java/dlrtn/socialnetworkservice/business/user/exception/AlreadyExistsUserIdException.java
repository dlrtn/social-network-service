package dlrtn.socialnetworkservice.business.user.exception;

public class AlreadyExistsUserIdException extends RuntimeException {

    private static final String message = "Failed by existed user id";

    public AlreadyExistsUserIdException() {
        super(message);
    }

}

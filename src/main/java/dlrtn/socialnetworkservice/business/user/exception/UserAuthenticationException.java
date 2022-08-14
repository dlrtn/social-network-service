package dlrtn.socialnetworkservice.business.user.exception;

public class UserAuthenticationException extends RuntimeException {

    private static final String message = "Can't find user";

    public UserAuthenticationException() {
        super(message);
    }

}

package dlrtn.sns.business.user.domain.exception;

public class UserAlreadyExistsException extends IllegalArgumentException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public static void checkAndThrow(boolean exists) {
        if (exists) {
            throw new UserAlreadyExistsException("Email already exists");
        }
    }

}

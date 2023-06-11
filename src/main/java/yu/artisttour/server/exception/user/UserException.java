package yu.artisttour.server.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserException extends RuntimeException{
    private UserErrorCode errorCode;
    private String message;


}

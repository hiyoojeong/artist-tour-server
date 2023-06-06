package yu.artisttour.server.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_ID(HttpStatus.CONFLICT, ""),
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, ""),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND,""),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED,"");

    private HttpStatus httpStatus;
    private String message;


}
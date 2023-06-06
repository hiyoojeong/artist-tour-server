package yu.artisttour.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yu.artisttour.server.exception.user.UserException;

@RestControllerAdvice
public class ExceptionManager {

    // User 관련 예외처리
    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> userExceptionHandler(UserException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(new ErrorMessage(e.getErrorCode().getHttpStatus(), e.getErrorCode().name(), e.getMessage()));
    }

    // Runtime 예외처리
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

}

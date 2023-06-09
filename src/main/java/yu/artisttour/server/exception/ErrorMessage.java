package yu.artisttour.server.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus httpStatus;

    private String error;

    private String error_msg;

}

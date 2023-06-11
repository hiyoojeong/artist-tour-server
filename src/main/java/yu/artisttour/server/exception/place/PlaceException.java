package yu.artisttour.server.exception.place;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlaceException extends RuntimeException{

    private PlaceErrorCode errorCode;
    private String message;

}

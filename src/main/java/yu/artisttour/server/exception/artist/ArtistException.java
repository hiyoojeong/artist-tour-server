package yu.artisttour.server.exception.artist;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArtistException extends RuntimeException{

    private ArtistErrorCode errorCode;
    private String message;

}

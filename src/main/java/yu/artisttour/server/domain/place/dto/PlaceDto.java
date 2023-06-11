package yu.artisttour.server.domain.place.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PlaceDto {

    private String artistName;

    private String placeName;

    private String address;

    private Date date;

    private String content;

}

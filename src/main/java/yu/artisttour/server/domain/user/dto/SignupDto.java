package yu.artisttour.server.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {

    private String id;

    private String password;

    private String email;

    private String name;

    private String nickname;

}

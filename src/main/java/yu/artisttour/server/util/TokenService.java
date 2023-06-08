package yu.artisttour.server.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.user.security.JwtAuthenticationFilter;
import yu.artisttour.server.domain.user.security.JwtGenerator;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class TokenService {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final JwtGenerator jwtGenerator;

    public String getIdByRequest(HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getJwtFromRequest(request);
        String id = jwtGenerator.getIdFromJWT(token);

        return id;
    }


}

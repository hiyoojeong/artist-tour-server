package yu.artisttour.server.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.domain.user.repository.UserRepository;
import yu.artisttour.server.domain.user.security.JwtAuthenticationFilter;
import yu.artisttour.server.domain.user.security.JwtGenerator;
import yu.artisttour.server.exception.user.UserErrorCode;
import yu.artisttour.server.exception.user.UserException;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class TokenService {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final JwtGenerator jwtGenerator;

    private final UserRepository userRepository;

    public Long getUserIdByRequest(HttpServletRequest request) {
        // 토큰 추출
        String token = jwtAuthenticationFilter.getJwtFromRequest(request);
        // 아이디 추출
        String username = jwtGenerator.getIdFromJWT(token);
        // userId 추출
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(UserErrorCode.USERNAME_NOT_FOUND, "사용자를 찾을 수 없습니다."));
        return user.getUserId();
    }


}

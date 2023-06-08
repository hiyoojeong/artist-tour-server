package yu.artisttour.server.domain.user.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.domain.user.repository.UserRepository;
import yu.artisttour.server.exception.user.ErrorCode;
import yu.artisttour.server.exception.user.UserException;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {



    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(ErrorCode.USERNAME_NOT_FOUND,"Username not found"));

        return new UserDetailsImpl(user);
    }
}

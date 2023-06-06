package yu.artisttour.server.domain.user.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import yu.artisttour.server.domain.user.entity.UserEntity;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {


    private final UserEntity userEntity;

    public UserDetailsImpl(UserEntity user){this.userEntity = user;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }


    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

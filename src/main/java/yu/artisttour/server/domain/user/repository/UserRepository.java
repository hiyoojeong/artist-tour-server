package yu.artisttour.server.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpNE;
import org.springframework.transaction.annotation.Transactional;
import yu.artisttour.server.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);

    @Transactional
    String deleteByUserId(Long userId);

    List<User> findAll();

    Optional<User> findByUserId(Long userId);

}

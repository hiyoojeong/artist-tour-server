package yu.artisttour.server.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import yu.artisttour.server.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    User save(User user);

    @Transactional
    String deleteById(String id);

    List<User> findAll();

}

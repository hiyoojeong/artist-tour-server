package yu.artisttour.server.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import yu.artisttour.server.domain.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findById(String id);

    Optional<UserEntity> findByEmail(String email);

    @Transactional
    String deleteById(String id);

    List<UserEntity> findAll();

}

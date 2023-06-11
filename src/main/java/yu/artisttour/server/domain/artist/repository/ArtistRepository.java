package yu.artisttour.server.domain.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.artisttour.server.domain.artist.entity.Artist;
import yu.artisttour.server.domain.place.entity.Place;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAll();

    Optional<Artist> findByArtistId(Long artistId);
}

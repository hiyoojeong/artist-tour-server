package yu.artisttour.server.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.artisttour.server.domain.artist.entity.Artist;
import yu.artisttour.server.domain.place.entity.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place save(Place place);

    Optional<Place> findByPlaceId(Long placeId);

    List<Place> findAll();

}

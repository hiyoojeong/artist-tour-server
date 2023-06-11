package yu.artisttour.server.domain.artist.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.artist.repository.ArtistRepository;

@Service
@AllArgsConstructor
public class ArtistService {

    private ArtistRepository artistRepository;

    public ResponseEntity getArtistList() {
        return ResponseEntity.ok(artistRepository.findAll());
    }



}

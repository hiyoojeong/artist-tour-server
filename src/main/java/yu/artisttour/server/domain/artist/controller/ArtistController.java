package yu.artisttour.server.domain.artist.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.artisttour.server.domain.artist.service.ArtistService;

@RestController
@RequestMapping("artist")
@AllArgsConstructor
public class ArtistController {

    private ArtistService artistService;

    @GetMapping("/list")
    private ResponseEntity getArtistList(){
        return artistService.getArtistList();
    }

}

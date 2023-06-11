package yu.artisttour.server.domain.place.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.artist.entity.Artist;
import yu.artisttour.server.domain.artist.repository.ArtistRepository;
import yu.artisttour.server.domain.place.dto.PlaceRequestDto;
import yu.artisttour.server.domain.place.dto.PlaceDto;
import yu.artisttour.server.domain.place.entity.Place;
import yu.artisttour.server.domain.place.repository.PlaceRepository;
import yu.artisttour.server.domain.subscribe.entity.Subscribe;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.domain.user.repository.UserRepository;
import yu.artisttour.server.exception.artist.ArtistErrorCode;
import yu.artisttour.server.exception.artist.ArtistException;
import yu.artisttour.server.exception.place.PlaceErrorCode;
import yu.artisttour.server.exception.place.PlaceException;
import yu.artisttour.server.exception.user.UserErrorCode;
import yu.artisttour.server.exception.user.UserException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlaceService {

    private PlaceRepository placeRepository;

    private UserRepository userRepository;

    private ArtistRepository artistRepository;

    public ResponseEntity getPlaces(Long userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserException(UserErrorCode.USERID_NOT_FOUND, "존재하지 않는 회원입니다."));
        List<Subscribe> subscribes = user.getSubscribes();

        List<Long> artistIds = new ArrayList<>();
        for (Subscribe subscribe : subscribes) {
            Artist artist = subscribe.getArtist();
            artistIds.add(artist.getArtistId());
        }

        List<Place> places = new ArrayList<>();
        for (Long artistId : artistIds) {
            Artist artist = artistRepository.findByArtistId(artistId).orElseThrow(() -> new ArtistException(ArtistErrorCode.ARTISTID_NOT_FOUND, "존재하지 않는 아티스트입니다."));
            if (artist != null) {
                places.addAll(artist.getPlaces());
            }
        }

        return ResponseEntity.ok(places);

    }

    public ResponseEntity getPlace(PlaceRequestDto placeRequestDto) {
        Place place = placeRepository.findByPlaceId(placeRequestDto.getPlaceId()).orElseThrow(() -> new PlaceException(PlaceErrorCode.PLACEID_NOT_FOUND, "존재하지 않는 플레이스입니다."));

        Artist artist = place.getArtist();
        if (artist == null) {throw new ArtistException(ArtistErrorCode.ARTISTID_NOT_FOUND, "존재하지 않는 아티스트입니다.");}

        PlaceDto placeDto = PlaceDto.builder()
                .artistName(artist.getName())
                .placeName(place.getName())
                .address(place.getAddress())
                .date(place.getDate())
                .content(place.getContent())
                .build();
        return ResponseEntity.ok(placeDto);
    }

}

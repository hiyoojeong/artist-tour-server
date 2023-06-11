package yu.artisttour.server.domain.place.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.artisttour.server.domain.place.dto.PlaceRequestDto;
import yu.artisttour.server.domain.place.service.PlaceService;
import yu.artisttour.server.util.TokenService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("place")
@AllArgsConstructor
public class PlaceController {

    private PlaceService placeService;

    private TokenService tokenService;

    @GetMapping("/list")
    private ResponseEntity getPlaces(HttpServletRequest request) {
        Long userId = tokenService.getUserIdByRequest(request);
        return ResponseEntity.ok(placeService.getPlaces(userId));
    }

    @PostMapping
    private ResponseEntity getPlace(@RequestBody PlaceRequestDto placeRequestDto) {
        return placeService.getPlace(placeRequestDto);
    }

}

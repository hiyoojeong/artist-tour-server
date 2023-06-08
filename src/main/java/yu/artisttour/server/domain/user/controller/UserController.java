package yu.artisttour.server.domain.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.artisttour.server.domain.user.dto.DuplicatedCheckDto;
import yu.artisttour.server.domain.user.dto.LoginDto;
import yu.artisttour.server.domain.user.dto.SignupDto;
import yu.artisttour.server.domain.user.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @PostMapping("/signup/check-id")
    private ResponseEntity checkId(@RequestBody DuplicatedCheckDto duplicatedCheckDto) {
        return userService.isUplicatedId(duplicatedCheckDto.getDuplicatedCheck());
    }

    @PostMapping("/signup/check-email")
    private ResponseEntity checkEmail(@RequestBody DuplicatedCheckDto duplicatedCheckDto) {
        return userService.isUplicatedEmail(duplicatedCheckDto.getDuplicatedCheck());
    }

    @PostMapping("/signup")
    private ResponseEntity signup(@RequestBody SignupDto signupDto) {
        return userService.signup(signupDto);
    }

}

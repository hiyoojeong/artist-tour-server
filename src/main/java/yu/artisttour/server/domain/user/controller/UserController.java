package yu.artisttour.server.domain.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.artisttour.server.domain.user.dto.DuplicatedCheckDto;
import yu.artisttour.server.domain.user.dto.LoginDto;
import yu.artisttour.server.domain.user.dto.SignupDto;
import yu.artisttour.server.domain.user.entity.UserEntity;
import yu.artisttour.server.domain.user.security.JwtAuthenticationFilter;
import yu.artisttour.server.domain.user.security.JwtGenerator;
import yu.artisttour.server.domain.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final JwtGenerator jwtGenerator;

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

    @GetMapping("/withdraw")
    private ResponseEntity withdraw(HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getJwtFromRequest(request);
        String id = jwtGenerator.getIdFromJWT(token);

        return userService.withdraw(id);
    }

    @GetMapping("/user/list")
    private ResponseEntity<List<UserEntity>> userList() {
        return userService.userList();
    }

}

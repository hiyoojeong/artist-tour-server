package yu.artisttour.server.domain.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.artisttour.server.domain.user.dto.DuplicatedCheckDto;
import yu.artisttour.server.domain.user.dto.LoginDto;
import yu.artisttour.server.domain.user.dto.SignupDto;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.domain.user.service.UserService;
import yu.artisttour.server.util.TokenService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final TokenService tokenService;

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody LoginDto loginDto) {

        System.out.println(loginDto.getUsername());
        System.out.println(loginDto.getPassword());
        return userService.login(loginDto);
    }

    @PostMapping("/signup/check-username")
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
        Long userId = tokenService.getUserIdByRequest(request);
        return userService.withdraw(userId);
    }

    @GetMapping("/user/list")
    private ResponseEntity<List<User>> userList() {
        return userService.userList();
    }

}

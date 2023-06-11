package yu.artisttour.server.domain.user.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.user.dto.SignupDto;
import yu.artisttour.server.domain.user.dto.TokenDto;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.domain.user.repository.UserRepository;
import yu.artisttour.server.exception.user.ErrorCode;
import yu.artisttour.server.exception.user.UserException;
import yu.artisttour.server.domain.user.dto.LoginDto;
import yu.artisttour.server.domain.user.security.JwtGenerator;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final JwtGenerator jwtGenerator;

    private final ModelMapper modelMapper;

    private User convertToEntity(SignupDto signupDto) {
        return modelMapper.map(signupDto, User.class);
    }

    // 아아디 중복 확인
    public ResponseEntity isUplicatedId(String username) {
        userRepository.findByUsername(username)
                .ifPresent(m ->{
                    throw new UserException(ErrorCode.DUPLICATED_ID, "이미 존재하는 아이디입니다.");
                });
        return new ResponseEntity(HttpStatus.OK);
    }

    // 이메일 중복 확인
    public ResponseEntity isUplicatedEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(m ->{
                    throw new UserException(ErrorCode.DUPLICATED_EMAIL, "이미 존재하는 이메일입니다.");
                });
        return new ResponseEntity(HttpStatus.OK);
    }

    // 로그인
    public ResponseEntity login(LoginDto loginDto) {
        // 로그인 실패: 입력한 아이디가 존재하지 않는 경우
        User user = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new UserException(ErrorCode.USERNAME_NOT_FOUND, "회원이 아닙니다."));

        // 로그인 실패: 비밀번호가 일치하지 않는 경우
        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UserException(ErrorCode.INVALID_PASSWORD, "비밀번호가 일치하지 않습니다.");
        }

        // 로그인 성공: 토큰 발행
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        // ResponseEntity 생성 및 반환
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        return new ResponseEntity<>(new TokenDto(token), httpHeaders, HttpStatus.OK);


    }

    // 회원가입
    public ResponseEntity signup(SignupDto signupDto)
    {
        // 비밀번호 암호화
        signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));

        System.out.println(signupDto.getPassword());

        User user = convertToEntity(signupDto);
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);

    }

    // 회원탈퇴
    public ResponseEntity withdraw(Long userId)
    {
        userRepository.deleteByUserId(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    // 회원조회
    public ResponseEntity userList() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    // userId 가져오기
    public Long getUserIdByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorCode.USERNAME_NOT_FOUND, "사용자를 찾을 수 없습니다."));
        return user.getUserId();
    }

}

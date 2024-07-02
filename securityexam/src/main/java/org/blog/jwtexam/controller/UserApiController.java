package org.blog.jwtexam.controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.blog.jwtexam.domain.RefreshToken;
import org.blog.jwtexam.domain.Role;
import org.blog.jwtexam.domain.User;
import org.blog.jwtexam.dto.UserLoginResponseDto;
import org.blog.jwtexam.jwt.util.JwtTokenizer;
import org.blog.jwtexam.security.dto.UserLoginDto;
import org.blog.jwtexam.service.RefreshTokenService;

import org.blog.jwtexam.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLoginDto loginDto , BindingResult bindingResult , HttpServletResponse httpServletResponse){
        //username , password가  null일때 혹은 정해진 형식에 맞지않을때
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        //해당 username으로 유저정보 가져와서 아이디비밀번호 맞는지 체크 맞지않다면 return
        User user = userService.findByUserName(loginDto.getUsername());
        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        //여기까지체크한건 아이디비밀번호 일치하는지 체크. 아이디비밀번호맞음.

        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList()); //Role타입의 set에서 role의 이름만 들어있는 list가 필요함

        //액세스토큰과 리프레시토큰 생성
        String accessToken = jwtTokenizer.createAccessToken(user.getId(),user.getEmail(),user.getName(),user.getUsername(),roles);
        String refreshToken = jwtTokenizer.createRefreshToken(user.getId(),user.getEmail(),user.getName(),user.getUsername(),roles);

        //리프레시토큰 같은 경우엔 디비에 넣어줘야하니까 객체생성해서 넣어줌.
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setValue(refreshToken);
        refreshTokenEntity.setUserId(user.getId());
        refreshTokenService.addRefreshToken(refreshTokenEntity);

        //응답을 위한 dto에 로그인정보 담아주기
        UserLoginResponseDto loginResponse = UserLoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .name(user.getName())
                .build();

        //쿠키에 액세스토큰 담아주기
        Cookie accessTokenCookie = new Cookie("accessToken",accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.ACCESS_TOKEN_EXPIRE_COUNT/1000));//30분 30분이 다되면 refresh토큰 가지고 다시 요청해서 맞으면 새로운 accesstoken 발급해준다.

        //쿠키에 리프레시토큰 담아주기
        Cookie refreshTokenCookie = new Cookie("refreshToken" , refreshToken);
        refreshTokenCookie.setHttpOnly(true);//보안. (쿠키값을 js곳에서 접근할 수 없다.)
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.REFRESH_TOKEN_EXPIRE_COUT/1000));//유지시간. 7일 / 쿠키의 유지시간은 초단위인데 JWT의 시간단위는 밀리세컨드라 나눠줌.

        //서블릿응답에 보내기
        httpServletResponse.addCookie(accessTokenCookie);
        httpServletResponse.addCookie(refreshTokenCookie);

        //엔티티에 로그인정보담아서 return
        return new ResponseEntity(loginResponse , HttpStatus.OK);
    }

    @GetMapping("/api/authtest")
    public String authTest(){
        return "authTest";
    }

    @PostMapping("/refreshToken")
    public ResponseEntity refreshToken(HttpServletRequest request,HttpServletResponse response){
        //쿠키로부터 리프레시토큰을 얻어온다.
        String refreshToken = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if("refreshToken".equals(cookie.getName())){
                    System.out.println("찾음");
                    refreshToken = cookie.getValue();
                    break;
                }
            }
        }
        //리프레시토큰이 없는경우 반환
        if(refreshToken==null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        //리프레시토큰이 있는경우 토큰에 대한 유저아이디 가져오고 그 유저에대한정보가져오기
        Claims claims = jwtTokenizer.parseRefreshToken(refreshToken);
        Long userId = Long.valueOf((Integer) claims.get("userId"));
        User user = userService.getUser(userId).orElseThrow(()-> new IllegalArgumentException("사용자를 찾지 못했습니다"));

        //액세스토큰 생성
        List roles = (List)claims.get("roles");
        String accessToken = jwtTokenizer.createAccessToken(userId , user.getEmail(),user.getName(),user.getUsername(),roles);

        //쿠키생성 response로 보낸다.
        Cookie accessTokenCookie = new Cookie("accessToken",accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.ACCESS_TOKEN_EXPIRE_COUNT/1000));
        //response 쿠키에 넣기
        response.addCookie(accessTokenCookie);

        //요청에 대한 응답을 보낼 객체
        UserLoginResponseDto dto = UserLoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .name(user.getName())
                .userId(user.getId())
                .build();
        return new ResponseEntity(dto , HttpStatus.OK);
    }
}

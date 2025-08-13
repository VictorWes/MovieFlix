package br.com.movieflix.MovieFlix.Controller;


import br.com.movieflix.MovieFlix.Controller.request.UserRequest;
import br.com.movieflix.MovieFlix.Controller.response.UserResponse;
import br.com.movieflix.MovieFlix.entity.User;
import br.com.movieflix.MovieFlix.mapper.UserMapper;
import br.com.movieflix.MovieFlix.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
public class AuthController {

    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){

        User savedUser = userService.saveUser(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toResponse(savedUser));

    }
}

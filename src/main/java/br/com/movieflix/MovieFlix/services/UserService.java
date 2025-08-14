package br.com.movieflix.MovieFlix.services;


import br.com.movieflix.MovieFlix.entity.User;
import br.com.movieflix.MovieFlix.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user){

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }
}

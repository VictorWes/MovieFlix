package br.com.movieflix.MovieFlix.services;


import br.com.movieflix.MovieFlix.entity.User;
import br.com.movieflix.MovieFlix.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}

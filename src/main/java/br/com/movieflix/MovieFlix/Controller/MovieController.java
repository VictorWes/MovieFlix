package br.com.movieflix.MovieFlix.Controller;

import br.com.movieflix.MovieFlix.services.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}

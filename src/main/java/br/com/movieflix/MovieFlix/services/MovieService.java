package br.com.movieflix.MovieFlix.services;

import br.com.movieflix.MovieFlix.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository  movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}

package br.com.movieflix.MovieFlix.Controller;

import br.com.movieflix.MovieFlix.Controller.request.MovieRequest;
import br.com.movieflix.MovieFlix.Controller.response.MovieResponse;
import br.com.movieflix.MovieFlix.entity.Movie;
import br.com.movieflix.MovieFlix.mapper.MovieMapper;
import br.com.movieflix.MovieFlix.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request){
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());

    }
}

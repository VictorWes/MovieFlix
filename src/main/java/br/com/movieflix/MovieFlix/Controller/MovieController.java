package br.com.movieflix.MovieFlix.Controller;

import br.com.movieflix.MovieFlix.Controller.request.MovieRequest;
import br.com.movieflix.MovieFlix.Controller.response.MovieResponse;
import br.com.movieflix.MovieFlix.entity.Movie;
import br.com.movieflix.MovieFlix.mapper.MovieMapper;
import br.com.movieflix.MovieFlix.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/movie")
@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }



    @Operation(summary = "Salvar filme", description = "Metodo responsavel por realizar o salvamento de um novo filme",
    security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
    content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PostMapping
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request){
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }


    @Operation(summary = "Buscar filmes", description = "Metodo responsavel por listar todos os filmes",
    security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados.",
    content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());

    }

    @Operation(summary = "Busca filme por codigo", description = "Busca filme por codigo especifico. ex: 1",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id){
       return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category){
        return ResponseEntity.ok(movieService.findByCategorie(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request){

        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        Optional<Movie> optMovie = movieService.findById(id);
        if (optMovie.isPresent()){
            movieService.delete(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}

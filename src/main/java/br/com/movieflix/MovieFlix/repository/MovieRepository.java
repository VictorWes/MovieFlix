package br.com.movieflix.MovieFlix.repository;

import br.com.movieflix.MovieFlix.entity.Category;
import br.com.movieflix.MovieFlix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);
    List<Movie> findTop5ByOrderByRatingDesc();

}

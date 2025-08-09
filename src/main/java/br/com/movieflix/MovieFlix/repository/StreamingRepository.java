package br.com.movieflix.MovieFlix.repository;

import br.com.movieflix.MovieFlix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}

package br.com.movieflix.MovieFlix.repository;

import br.com.movieflix.MovieFlix.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

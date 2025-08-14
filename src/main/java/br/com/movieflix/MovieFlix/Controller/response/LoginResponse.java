package br.com.movieflix.MovieFlix.Controller.response;


import lombok.Builder;

@Builder
public record LoginResponse(String token) {
}

package br.com.movieflix.MovieFlix.Controller.request;

import lombok.Builder;

@Builder
public record LoginRequest(String email, String password) {
}

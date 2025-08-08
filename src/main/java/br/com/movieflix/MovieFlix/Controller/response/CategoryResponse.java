package br.com.movieflix.MovieFlix.Controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String nome) {
}

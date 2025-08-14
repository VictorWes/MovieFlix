package br.com.movieflix.MovieFlix.Controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CategoryRequest(@NotEmpty(message = "Nome da categoria é obrigatorio") String nome) {

}

package br.com.movieflix.MovieFlix.Controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest (@NotEmpty(message = "Nome do streaming é obrigatorio") String nome){

}

package br.com.movieflix.MovieFlix.Controller.request;

import lombok.Builder;

@Builder
public record CategoryRequest(String nome) {

}

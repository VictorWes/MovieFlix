package br.com.movieflix.MovieFlix.Controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(@Schema(type = "string", description = "Nome do filme")
                           @NotEmpty(message = "Titulo do filme é obrigatorio. ")
                           String title,

                           @Schema(type = "string", description = "Descrição do filme")
                           String description,


                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "date", description = "Data de lançamento do filme. Ex: 19/10/1995")
                           LocalDate releaseDate,

                           @Schema(type = "date", description = "Escore do filme. ex: 7.5")
                           double rating,
                           @Schema(type = "array", description = "Lista de codigo de categoria")
                           List<Long> categories,

                           @Schema(type = "array", description = "Lista de codigo de serviço de streaming")
                           List<Long> streamings){

}
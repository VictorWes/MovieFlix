package br.com.movieflix.MovieFlix.mapper;

import br.com.movieflix.MovieFlix.Controller.request.StreamingRequest;
import br.com.movieflix.MovieFlix.Controller.response.StreamingResponse;
import br.com.movieflix.MovieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){

        return Streaming
                .builder()
                .nome(streamingRequest.nome())
                .build();
    }

    public static StreamingResponse toResponse(Streaming streaming){

        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .nome(streaming.getNome())
                .build();
    }

}

package br.com.movieflix.MovieFlix.services;


import br.com.movieflix.MovieFlix.entity.Streaming;
import br.com.movieflix.MovieFlix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> findAll(){
        return streamingRepository.findAll();
    }

    public Streaming saveStreaming(Streaming category){
        return streamingRepository.save(category);
    }

    public Optional<Streaming> findById(Long id){
        return streamingRepository.findById(id);
    }

    public void deleteStreamingById(Long id){
        streamingRepository.deleteById(id);
    }

}

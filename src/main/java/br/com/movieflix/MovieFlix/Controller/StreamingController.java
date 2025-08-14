package br.com.movieflix.MovieFlix.Controller;

import br.com.movieflix.MovieFlix.Controller.request.StreamingRequest;
import br.com.movieflix.MovieFlix.Controller.response.StreamingResponse;
import br.com.movieflix.MovieFlix.entity.Streaming;
import br.com.movieflix.MovieFlix.mapper.MovieMapper;
import br.com.movieflix.MovieFlix.mapper.StreamingMapper;
import br.com.movieflix.MovieFlix.services.StreamingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {


    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreaming() {
        List<StreamingResponse> categories = streamingService.findAll()
                .stream()
                .map(StreamingMapper::toResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> saveStreaming(@Valid @RequestBody StreamingRequest request) {

        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toResponse(savedStreaming));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findStreamingById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarByStreamingId(@PathVariable Long id) {
        streamingService.deleteStreamingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> updateStreaming(@PathVariable Long id, @RequestBody StreamingRequest request){

        return streamingService.update(id, StreamingMapper.toStreaming(request))
                .map(content -> ResponseEntity.ok(StreamingMapper.toResponse(content)))
                .orElse(ResponseEntity.notFound().build());

    }
}

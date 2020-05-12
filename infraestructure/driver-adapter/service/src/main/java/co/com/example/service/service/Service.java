package co.com.example.service.service;

import co.com.example.domain.json.Book;
import co.com.example.domain.json.gateway.IBookDao;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Service implements IBookDao {

     private  final WebClient webClient;

    public Service(WebClient.Builder webClientbuilder) {
        webClient = webClientbuilder
                .baseUrl("https://jsonplaceholder.typicode.com/posts")
                .build();
    }

    @Override
    public Flux<Book> findAll() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Book.class);
    }

    @Override
    public Mono<Book> findById(Integer id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Book.class);
    }
}

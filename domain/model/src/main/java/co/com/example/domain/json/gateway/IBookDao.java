package co.com.example.domain.json.gateway;

import co.com.example.domain.json.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBookDao {

    Flux<Book> findAll();
    Mono<Book> findById(Integer id);
}

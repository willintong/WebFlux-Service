package co.com.example.domain.json.gateway;

import co.com.example.domain.json.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookIBookDaoImpl implements  IBookDao {

    @Override
    public Flux<Book> findAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, 23224,"New Book","Mi primera inserción"));
        books.add(new Book(1, 44567434,"New Book two","Mi segunada inserción"));
        return Flux.fromIterable(books);
    }

    @Override
    public Mono<Book> findById(long id) {
        return Mono.just(new Book(1,35454,"New Book there","Mi tercera inserción"));
    }

}

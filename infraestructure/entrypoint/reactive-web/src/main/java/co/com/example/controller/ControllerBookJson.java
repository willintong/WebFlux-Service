package co.com.example.controller;

import co.com.example.domain.json.Book;
import co.com.example.domain.json.gateway.IBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/posts")
public class ControllerBookJson {

    @Autowired
    private IBookDao bookDao;

    @GetMapping
    public Flux<Book> findAll(){
        return bookDao.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> findById(@PathVariable Integer id){
        return bookDao.findById(id);
    }

}

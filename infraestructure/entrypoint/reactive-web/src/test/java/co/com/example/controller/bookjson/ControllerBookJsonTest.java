package co.com.example.controller.bookjson;

import co.com.example.controller.ControllerBookJson;
import co.com.example.domain.json.Book;
import co.com.example.domain.json.gateway.IBookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static reactor.core.publisher.Mono.when;

@WebFluxTest(ControllerBookJson.class)
public class ControllerBookJsonTest {

    @MockBean
    private IBookDao bookDao;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnFromRepository(){
        Book book = new Book(1,2,"My Title","cuerpo del titulo");

        when(bookDao.findAll())
                .thenReturn(Flux.just(Book.class));

        webTestClient.get()
                .uri("/posts")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Book.class)
                .hasSize(1);
    }

}

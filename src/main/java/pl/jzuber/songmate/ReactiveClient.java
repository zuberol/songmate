package pl.jzuber.songmate;


import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
    Fake client class. Sends requests.
 */


public class ReactiveClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = client.get()
            .uri("/chat")
            .accept(MediaType.APPLICATION_STREAM_JSON)
            .exchange();





    public String getResult() {
        return "produced: " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
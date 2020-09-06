package pl.jzuber.songmate.eventHandlers;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class EchoWebSocketHandler implements WebSocketHandler {

    @Override
    public List<String> getSubProtocols() {
        return null;
    }


    // handles two way 'echo' functionality
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> out = session.receive()
                .doOnNext(System.out::println)
                .map(value -> session.textMessage("Echo:" + value.getPayloadAsText()));


        return session.send(out);
    }
}

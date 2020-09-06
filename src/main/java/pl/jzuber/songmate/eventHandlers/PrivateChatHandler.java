package pl.jzuber.songmate.eventHandlers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import pl.jzuber.songmate.monkey.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.UnicastProcessor;

import java.util.List;

public class PrivateChatHandler implements WebSocketHandler {

    private UnicastProcessor<WebSocketMessage> GlobalProcessor;
    private Flux<WebSocketMessage> events;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
//
//        //GlobalProcessor.onNext(session.receive());
//        session.receive()
//                .doOnNext(GlobalProcessor::onNext)
//                .doOnError(GlobalProcessor::onError)
//                .doOnComplete(GlobalProcessor::onComplete)
//                //.zipWith(session.send(GlobalProcessor))
//                .subscribe(GlobalProcessor);
//






        return session.send(events);





        //return session.send(GlobalProcessor);
//        return session.send(session.receive()
//                //.doOnNext(GlobalProcessor::onNext)
//                .doOnNext(System.out::println)
//                .map(value -> session.textMessage("Echo:" + value.getPayloadAsText()))
//        );



//
//        Flux<WebSocketMessage> out = session.receive()
//                .doOnNext(System.out::println)
//                .map(value -> session.textMessage(session.getId()+ " said: " + value.getPayloadAsText()));
//        return session.send(out);
    }





    public PrivateChatHandler(UnicastProcessor<WebSocketMessage> GlobalProcessor, Flux<WebSocketMessage> events) {
        this.events = events;
        this.GlobalProcessor = GlobalProcessor;
    }

    @Override
    public List<String> getSubProtocols() {
        return null;                    //TODO co to robi, po co to
    }

}

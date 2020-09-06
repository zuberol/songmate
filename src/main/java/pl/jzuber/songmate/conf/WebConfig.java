package pl.jzuber.songmate.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import pl.jzuber.songmate.eventHandlers.EchoWebSocketHandler;

import pl.jzuber.songmate.eventHandlers.PrivateChatHandler;
import pl.jzuber.songmate.monkey.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebConfig {

    @Bean
    public UnicastProcessor<Event> eventPublisher(){
        return UnicastProcessor.create();
    }

    @Bean
    public UnicastProcessor<WebSocketMessage> eventPublisherWSM(){
        return UnicastProcessor.create();
    }

    @Bean
    public Flux<WebSocketMessage> events(UnicastProcessor<WebSocketMessage> eventPublisherWSM) {
        return eventPublisherWSM
                .replay(25)
                ;//.autoConnect();
    }



    @Bean
    public HandlerMapping handlerMapping(UnicastProcessor<WebSocketMessage> eventPublisher, Flux<WebSocketMessage> events) {
        Map<String, WebSocketHandler> map = new HashMap<>();
        // map.put("/chat", new EchoWebSocketHandler());
        map.put("/app/msg", new PrivateChatHandler(eventPublisher, events));
        int order = -1;             // before annotated controllers


        return new SimpleUrlHandlerMapping(map, order);
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter(){return new WebSocketHandlerAdapter();}
}

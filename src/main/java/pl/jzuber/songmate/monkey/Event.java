package pl.jzuber.songmate.monkey;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.reactive.socket.WebSocketMessage;

public class Event extends WebSocketMessage {
    public Event(WebSocketMessage.Type type, DataBuffer payload) {
        super(type, payload);
    }

//    public enum Type {
//        CHAT_MESSAGE, USER_JOINED, USER_STATS, USER_LEFT;
//    }
//
//    Type event_type;
//    long time;

//    public Event(Type event_type, long time) {
//        this.event_type = event_type;
//        this.time = System.currentTimeMillis();
//    }

}

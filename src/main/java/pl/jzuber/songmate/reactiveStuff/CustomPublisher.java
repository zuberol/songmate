package pl.jzuber.songmate.reactiveStuff;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import pl.jzuber.songmate.monkey.Event;

public class CustomPublisher implements Publisher<Event> {
    @Override
    public void subscribe(Subscriber<? super Event> subscriber) {

    }
}

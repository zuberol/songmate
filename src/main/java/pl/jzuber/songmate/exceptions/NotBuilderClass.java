package pl.jzuber.songmate.exceptions;

public class NotBuilderClass extends RuntimeException {
    public NotBuilderClass() {
        super("Builder method couldn't been found");
    }
}

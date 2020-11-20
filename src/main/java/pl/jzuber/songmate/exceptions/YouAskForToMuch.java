package pl.jzuber.songmate.exceptions;

public class YouAskForToMuch extends RuntimeException {
    public YouAskForToMuch(String msg){
        super(msg);
    }
}

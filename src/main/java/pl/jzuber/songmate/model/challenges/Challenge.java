package pl.jzuber.songmate.model.challenges;

import javax.persistence.*;

import lombok.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.experimental.SuperBuilder;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.utils.CustomChallengeDeserializer;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@SuperBuilder
@JsonDeserialize(using = CustomChallengeDeserializer.class)
public abstract class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String challenge_name;
    protected  User addressee;
    protected User recipient;

    public Challenge(Long id, String challenge_name, User addressee, User recipient) {
        this.id = id;
        this.challenge_name = challenge_name;
        this.addressee = addressee;
        this.recipient = recipient;
    }

    public abstract boolean isValidChallenge();

    @Override
    public String toString(){
        return "udalo sie"; //return addressee.getId() + "," + challenge_name + "," + addressee.getUsername() + "," + recipient.getUsername();
    }

}
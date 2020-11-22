package pl.jzuber.songmate.model.challenges;

import javax.persistence.*;

import lombok.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.experimental.SuperBuilder;
import pl.jzuber.songmate.model.User;
import pl.jzuber.songmate.utils.CustomChallengeDeserializer;

@MappedSuperclass   // JPA chyba, nie pamietam
@JsonDeserialize(using = CustomChallengeDeserializer.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@SuperBuilder
public abstract class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String challengeName;
    protected  User addressee;
    protected User recipient;


    public abstract boolean isValidChallenge();

    @Override
    public String toString(){
        return "udalo sie"; //return addressee.getId() + "," + challenge_name + "," + addressee.getUsername() + "," + recipient.getUsername();
    }

}
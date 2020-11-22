package pl.jzuber.songmate.model.challenges;

import antlr.SemanticException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pl.jzuber.songmate.model.User;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public final class SendMeSongChallenge extends Challenge {
    private String some_shit;


    public SendMeSongChallenge(Long id, User addressee, User recipient) {
        super(id, "SendMeSongChallenge", addressee, recipient);
    }

    @Override
    public boolean isValidChallenge() {
        return challengeName == null || addressee == null || recipient == null;
    }

    @Override
    public String toString() {
        return "SendMeSongChallenge{" +
                "some_shit='" + some_shit + '\'' +
                ", id=" + id +
                ", challenge_name='" + challengeName + '\'' +
                ", addressee=" + addressee +
                ", recipient=" + recipient +
                '}';
    }

//    public static void main(String[] args) {
//        System.out.println(SendMeSongChallenge.builder().addressee(null).recipient(null).id(1L).some_shit("some").challenge_name("cool").build());
//    }

}

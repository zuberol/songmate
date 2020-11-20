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
@SuperBuilder
@Getter @Setter
public final class SendMeSongChallenge extends Challenge {
    private String some_shit;

    public SendMeSongChallenge(Long id, User addressee, User recipient) {

        super(id, "SendMeSongChallenge", addressee, recipient);
    }

    @Override
    public boolean isValidChallenge() {
        return challenge_name == null || addressee == null || recipient == null;
    }


}

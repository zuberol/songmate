package pl.jzuber.songmate.model.challenges;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pl.jzuber.songmate.model.User;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TrackRecommendationChallenge extends Challenge {

    String youTubeVideoId;

    public TrackRecommendationChallenge(Long id, String challengeName, User addressee, User recipient, String youTubeVideoId) {
        super(id, challengeName, addressee, recipient);
        this.youTubeVideoId = youTubeVideoId;
    }

    @Override
    public boolean isValidChallenge() {
        return true;
    }
}

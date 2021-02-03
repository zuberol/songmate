package pl.jzuber.songmate.model.challenges;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public abstract class Parent {
    protected String parent_prop;
}

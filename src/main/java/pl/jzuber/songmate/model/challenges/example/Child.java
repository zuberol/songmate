package pl.jzuber.songmate.model.challenges.example;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Child extends Parent {
    protected String child_prop;

    @Builder
    public Child(String parent_prop, String child_prop) {
        super(parent_prop);
        this.child_prop = child_prop;
    }

//    public String see() {
//        return super.parent_prop;
//    }


    @Override
    public String toString() {
        return "Child{" +
                "child_prop='" + child_prop + '\'' +
                ", parent_prop='" + parent_prop + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Child c = Child.builder().child_prop("some").parent_prop("eehe").build();

        System.out.println(c);
        System.out.println(c.getChild_prop());
        System.out.println(c.getParent_prop());
    }
}

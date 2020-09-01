package pl.jzuber.songmate.model;

import javax.persistence.*;

@Entity
public class ChallengeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String challenge_name;      //enum




}

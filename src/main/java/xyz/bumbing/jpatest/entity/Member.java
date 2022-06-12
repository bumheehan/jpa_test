package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    public void setTeam(Team team) {
        this.team = team;
    }

    @Builder
    public Member(String name){
        this.name = name;
    }




}

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    private Team team;

    public void setTeam(Team team) {
        this.team = team;
    }

    @Builder
    public Member(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

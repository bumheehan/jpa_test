package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "stadium",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @OrderBy("id DESC")
    private final Set<Team> teams = new LinkedHashSet<>();

    public void setTeam(Team team) {
        this.teams.add(team);
        team.setStadium(this);
    }

    @Builder
    public Stadium(String name){
        this.name = name;
    }




}

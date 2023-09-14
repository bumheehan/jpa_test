package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team",orphanRemoval = true,cascade = CascadeType.ALL)
    @OrderBy
    private List<Member> members = new ArrayList<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @Builder
    public Team(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}

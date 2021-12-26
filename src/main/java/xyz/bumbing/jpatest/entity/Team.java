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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team",orphanRemoval = true,cascade = CascadeType.ALL)
    @OrderBy
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name){
        this.name=name;
    }
}

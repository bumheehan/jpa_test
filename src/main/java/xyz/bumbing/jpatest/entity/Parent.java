package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
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
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private final List<Child> children = new ArrayList<>();

    private Parent(String name) {
        this.name = name;
    }

    public static Parent create(String name) {
        return new Parent(name);
    }
}

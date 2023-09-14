package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "parent_manual_id")
    private ParentManualId parentManualId;




    public static Child create(String name,Parent parent) {
        Child child = new Child();
        child.name = name;
        child.parent =parent;
        return child;
    }
    public static Child create(String name,ParentManualId parent) {
        Child child = new Child();
        child.name = name;
        child.parentManualId =parent;
        return child;
    }


}

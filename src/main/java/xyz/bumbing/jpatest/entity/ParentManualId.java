package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentManualId {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private final List<Child> children = new ArrayList<>();

    private ParentManualId(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ParentManualId create(Long id, String name) {
        return new ParentManualId(id,name);
    }
}

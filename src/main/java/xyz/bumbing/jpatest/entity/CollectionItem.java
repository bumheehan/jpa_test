package xyz.bumbing.jpatest.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CollectionItem {

    private String name;

    public CollectionItem(String name) {
        this.name = name;
    }
}

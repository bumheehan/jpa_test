package xyz.bumbing.jpatest.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "item",joinColumns = @JoinColumn(name = "category_id"))
    @OrderColumn(name = "order_idx")
    List<CollectionItem> collectionItems;

    public void setCollectionItems(List<CollectionItem> collectionItems) {
        this.collectionItems = collectionItems;
    }


}

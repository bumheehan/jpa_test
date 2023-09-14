package xyz.bumbing.jpatest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.bumbing.jpatest.entity.Category;
import xyz.bumbing.jpatest.entity.CategoryRepository;
import xyz.bumbing.jpatest.entity.CollectionItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    @Transactional
    public Category save(){
        Category category = new Category();

        CollectionItem item1 = new CollectionItem("item1");
        CollectionItem item2 = new CollectionItem("item2");
        CollectionItem item3 = new CollectionItem("item3");
        category.setCollectionItems(List.of(item1,item2,item3));

        return categoryRepository.save(category);
    }

    @Transactional
    public Category update(Long id){
        Category category2 = categoryRepository.findById(id).orElseThrow();
        category2.setCollectionItems(List.of(category2.getCollectionItems().get(2),category2.getCollectionItems().get(1),category2.getCollectionItems().get(0),category2.getCollectionItems().get(1)));
        return category2;
    }

}

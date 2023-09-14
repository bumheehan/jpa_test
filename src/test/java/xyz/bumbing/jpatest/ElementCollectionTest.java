package xyz.bumbing.jpatest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xyz.bumbing.jpatest.entity.Category;
import xyz.bumbing.jpatest.entity.CategoryRepository;
import xyz.bumbing.jpatest.entity.CollectionItem;
import xyz.bumbing.jpatest.service.CategoryService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class ElementCollectionTest {


    @Autowired
    CategoryService categoryService;
    @Test
    public void test1(){
        Category save = categoryService.save();
        categoryService.update(save.getId());

    }
}

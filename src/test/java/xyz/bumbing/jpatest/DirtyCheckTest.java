package xyz.bumbing.jpatest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import xyz.bumbing.jpatest.entity.*;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
@Rollback(value = false)
class DirtyCheckTest {


    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ParentManualRepository parentManualRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    TransactionTemplate transactionTemplate;

    @BeforeEach
    void init(){
        Parent parent = Parent.create("name1");

        Child c1 = Child.create("c1",parent);
        Child c2 = Child.create("c2",parent);
        parent.getChildren().add(c1);
        parent.getChildren().add(c2);
        parentRepository.save(parent);

        ParentManualId parent2 = ParentManualId.create(99L,"name2");

        Child c11 = Child.create("c11",parent2);
        Child c22 = Child.create("c22",parent2);
        parent2.getChildren().add(c11);
        parent2.getChildren().add(c22);
        parentManualRepository.save(parent2);


    }

    @Test
    @Transactional
    void test1(){

        Parent parent = parentRepository.findByName("name1");
        Child c3 = Child.create("c3",parent);
        parent.getChildren().add(c3);

    }
    @Test
    void test2(){

        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(status -> {
            Optional<ParentManualId> byId = parentManualRepository.findById(0L);
            ParentManualId parent = parentManualRepository.findByName("name2");

            Child c3 = Child.create("c3",parent);
            parent.getChildren().add(c3);
            return null;
        });



    }
}

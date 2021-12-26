package xyz.bumbing.jpatest;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import xyz.bumbing.jpatest.entity.Member;
import xyz.bumbing.jpatest.entity.Team;
import xyz.bumbing.jpatest.entity.TeamRepository;


@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(value = false)
class JpaTestApplicationTests {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @Order(1)
    void add() {
        Member han = Member.builder().name("han").build();
        Member bing = Member.builder().name("bing").build();
        Team home = Team.builder().name("home").build();
        home.getMembers().add(han);
        home.getMembers().add(bing);
        teamRepository.save(home);
    }

//    @Test
    @Order(2)
    void listTest(){
        Team team = teamRepository.findById(1L).get();

        Member bing = team.getMembers().get(1);

        Assertions.assertEquals(bing.getName(),"bing");


    }

}

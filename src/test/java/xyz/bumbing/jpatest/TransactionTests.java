package xyz.bumbing.jpatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import xyz.bumbing.jpatest.entity.MemberRepository;
import xyz.bumbing.jpatest.entity.Team;
import xyz.bumbing.jpatest.entity.TeamRepository;

import java.util.Optional;


@SpringBootTest
class TransactionTests {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test1(){
        add("A");
        find("A");
    }

    @Test
    @Rollback(value = false)
    @DisplayName("상위 트랜잭션 끝날때 한번에 SQL 나감을 확인")
    @Transactional
    void test2(){
        add("A");
        find("A");
        add("B");
        find("B");
    }

    @Test
    @Rollback(value = false)
    @DisplayName("더티체킹도 트랜잭션 끝날때 한번에 나가는지 확인1")
    @Transactional
    void test3(){
        add("A");
        update("A","B");
        update("B","C");
    }
    @Test
    @Rollback(value = false)
    @DisplayName("더티체킹도 트랜잭션 끝날때 한번에 나가는지 확인2")
    @Transactional
    void test4(){
        Team team =  Team.builder().name("A").build();
        teamRepository.save(team);
        team.setName("B");
        team.setName("C");
    }
    @Test
    @Rollback(value = false)
    @DisplayName("더티체킹도 트랜잭션 끝날때 한번에 나가는지 확인3")
    @Transactional
    void test5(){
        Team team =  Team.builder().name("A").build();
        teamRepository.save(team);

        Optional<Team> teamOptional = teamRepository.findByName("A");
        team.setName("B");

        teamOptional = teamRepository.findByName("B");
        team.setName("C");
    }
    @Test
    @Rollback(value = false)
    @DisplayName("더티체킹도 트랜잭션 끝날때 한번에 나가는지 확인4")
    @Transactional
    void test6(){
        Team team =  Team.builder().name("A").build();
        teamRepository.save(team);

        Optional<Team> teamOptional = teamRepository.findByName("A");
        team.setName("B");

        memberRepository.findById(1L);
        team.setName("C");
    }
    @Test
    @Rollback(value = false)
    @DisplayName("삭제 쿼리 확인")
    @Transactional
    void test7(){
        Team teamA =  Team.builder().name("A").build();
        teamRepository.save(teamA);

        teamRepository.findByName("A").ifPresent(s->teamRepository.delete(s));

        Team teamB =  Team.builder().name("B").build();
        teamRepository.save(teamB);

         teamRepository.findByName("B").ifPresent(s->teamRepository.delete(s));

    }
    @Test
    @Rollback(value = false)
    @DisplayName("삭제했다가 다시 넣으면 삭제쿼리나가는지 확인1")
    @Transactional
    void test8(){
        Team teamA =  Team.builder().name("A").build();
        teamRepository.save(teamA);

        teamRepository.findByName("A").ifPresent(s->teamRepository.delete(s));

        //새로운 객체
        Team teamAA =  Team.builder().name("A").build();
        teamRepository.save(teamAA);


    }
    @Test
    @Rollback(value = false)
    @DisplayName("삭제했다가 다시 넣으면 삭제쿼리나가는지 확인2")
    @Transactional
    void test9(){
        Team teamA =  Team.builder().name("A").build();
        teamRepository.save(teamA);

        teamRepository.findByName("A").ifPresent(s->teamRepository.delete(s));

        teamRepository.save(teamA); //delete된 엔티티 다시 머지 안됨
    }

    @Transactional
    void add(String name) {
        Team team =  Team.builder().name(name).build();
        teamRepository.save(team);
    }
    @Transactional
    void find(String name){
        Optional<Team> teamOptional = teamRepository.findByName(name);
        Team team = teamOptional.orElseThrow();
    }
    @Transactional
    void update (String name,String name2){
        Optional<Team> teamOptional = teamRepository.findByName(name);
        Team team = teamOptional.orElseThrow();
        team.setName(name2);
    }

    @Transactional
    void delete(String name){
        Optional<Team> teamOptional = teamRepository.findByName(name);
        teamOptional.ifPresent(s->teamRepository.delete(s));
    }

}

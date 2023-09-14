package xyz.bumbing.jpatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xyz.bumbing.jpatest.entity.*;
import xyz.bumbing.jpatest.service.MemberService;


@SpringBootTest
class RepoTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("memberService")
    void test_persist(){

        memberService.createMember(1);

        memberService.call();

    }

}

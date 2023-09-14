package xyz.bumbing.jpatest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import xyz.bumbing.jpatest.service.MemberService;
import xyz.bumbing.jpatest.service.MemberService2;

@SpringBootTest
@Rollback(value = false)
class ProxyTransactionTest {

    @Autowired
    MemberService2 memberService2;

    @Autowired
    MemberService memberService;

    @Test
    void test1(){
        memberService.createMultiple();
//        memberService2.createMultiple();

    }
}

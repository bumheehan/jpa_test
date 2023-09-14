package xyz.bumbing.jpatest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.bumbing.jpatest.entity.Member;
import xyz.bumbing.jpatest.entity.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl2 implements MemberService2 {

    private final MemberService memberService;

    @Override
//    @Transactional
    public void createMultiple(){
        for (int i = 0; i <10; i++) {
            memberService.createMember(i);
        }

        throw new RuntimeException();
    }



}

package xyz.bumbing.jpatest.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import xyz.bumbing.jpatest.entity.Member;
import xyz.bumbing.jpatest.entity.MemberRepository;
import xyz.bumbing.jpatest.entity.MemberRepository2;

import javax.persistence.EntityManager;

import static xyz.bumbing.jpatest.entity.QMember.member;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberRepository2 memberRepository2;
    private final EntityManager entityManager;

    private final TransactionTemplate transactionTemplate;

    @Override
    @Transactional
    public void createMember(int i){
        Member member = Member.builder().name("index" + i).build();
        member = memberRepository.save(member);
        member.setName(member.getName()+"test");
    }
    @Override
    @Transactional
    public void createMultiple(){
        //transactionTemplate set propagation
        transactionTemplate.setPropagationBehavior(Propagation.REQUIRES_NEW.value());


        for (int i = 0; i <10; i++) {
            int finalI = i;
            transactionTemplate.execute(status -> {
                createMember(finalI);
                return null;
            });
        }

        //
        throw new RuntimeException();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void call(){
        Member member1 = memberRepository.findById(1L).orElseThrow();
        log.info("1");

        Member member2 = memberRepository2.findById(1L).orElseThrow();
        log.info("2");
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        Member member3 = jpaQueryFactory.selectFrom(member).where(member.id.eq(1L)).fetchOne();
        log.info("3");


//
        log.info("member1 == member2 : "+(member1==member2));
        log.info("member1 == member3 : "+(member1==member3));
        log.info("member2 == member3 : "+(member2==member3));

    }

}

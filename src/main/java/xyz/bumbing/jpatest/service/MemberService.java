package xyz.bumbing.jpatest.service;

import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

    void createMember(int i);
    void createMultiple();

    void call();
}

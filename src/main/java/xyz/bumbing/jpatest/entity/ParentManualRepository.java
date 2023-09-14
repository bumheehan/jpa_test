package xyz.bumbing.jpatest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentManualRepository extends JpaRepository<ParentManualId, Long> {
    ParentManualId findByName(String name);
}
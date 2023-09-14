package xyz.bumbing.jpatest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeTestEntityRepository extends JpaRepository<TimeTestEntity, Long> {
}
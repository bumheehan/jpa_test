package xyz.bumbing.jpatest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findByName(String name);


}
package xyz.bumbing.jpatest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    Optional<Stadium> findByName(String name);
}
package xyz.bumbing.jpatest;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.bumbing.jpatest.entity.TimeTestEntity;
import xyz.bumbing.jpatest.entity.TimeTestEntityRepository;

@RestController
    @RequiredArgsConstructor
    public  class TimeController {
        private final TimeTestEntityRepository timeTestEntityRepository;
        private final JdbcTemplate jdbcTemplate;
        @GetMapping("add")
        @Transactional
        public void a(){
            String s = jdbcTemplate.queryForObject("select local_date from time_test_entity", String.class);
            System.out.println(s);
//            timeTestEntityRepository.findAll().forEach(TimeTestEntity::forceUpdate);
        }

    }
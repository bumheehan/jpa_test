package xyz.bumbing.jpatest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class JpaTestApplication {
    @PostConstruct
    public void setDefaultTimeZone() {
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

}

package xyz.bumbing.jpatest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import xyz.bumbing.jpatest.entity.TimeTestEntity;
import xyz.bumbing.jpatest.entity.TimeTestEntityRepository;

import java.time.*;

@Component
@RequiredArgsConstructor
public class Init implements ApplicationListener<ApplicationReadyEvent> {
    private final TimeTestEntityRepository timeTestEntityRepository;
    private final JdbcTemplate jdbcTemplate;

    //1s -> 1000ms 999ms
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        TimeTestEntity timeTestEntity = new TimeTestEntity();
//        timeTestEntity.setDateTime6(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
//        timeTestEntity.setDateTime(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
//        timeTestEntity.setTimestamp(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
//        timeTestEntity.setTimestamp6(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        timeTestEntity.setKey(0);
        timeTestEntity.setLocalDate(LocalDate.now());
//        timeTestEntity.setLocalDateConvert(LocalDate.now());
//        timeTestEntity.setLocalDateVarchar(LocalDate.now());
//        timeTestEntity.setLocalDateDateTime(LocalDate.now());

        //시간잘못보냄 이부분 수정필요

        LocalDateTime utc = LocalDateTime.of(2023, 9, 13, 1, 0, 0);
        timeTestEntity.setDateTimeNow(utc);
        timeTestEntity.setTimestampNow(utc);
        timeTestEntity.setTimestampInstantNow(utc.toInstant(ZoneOffset.UTC));

        //1ms = 1,000,000 nano sec
        //1micro sec = 1,000 nano sec
        //1nano sec = 1




//        timeTestEntityRepository.save(timeTestEntity);


        System.out.println(timeTestEntityRepository.findAll().get(0).getLocalDate());





    }
}

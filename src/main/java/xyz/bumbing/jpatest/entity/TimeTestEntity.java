package xyz.bumbing.jpatest.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class TimeTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datetime_6",columnDefinition = "DATETIME(6)")
    private LocalDateTime dateTime6;
    @Column(name = "datetime_0",columnDefinition = "DATETIME(0)")
    private LocalDateTime dateTime;
    @Column(name = "timestamp",columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;
    @Column(name = "timestamp_6",columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime timestamp6;
    @Column(name = "local_date",columnDefinition = "DATE")
    private LocalDate localDate;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "local_date_convert",columnDefinition = "DATE")
    private LocalDate localDateConvert;
    @Column(name = "local_date_varchar",columnDefinition = "VARCHAR(50)")
    private LocalDate localDateVarchar;

    @Column(name = "local_date_date_time",columnDefinition = "DATETIME(6)")
    private LocalDate localDateDateTime;

    @Column(name = "datetime_now",columnDefinition = "DATETIME(6)")
    private LocalDateTime dateTimeNow;
    @Column(name = "timestamp_now",columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime timestampNow;

    @Column(name = "instant_now",columnDefinition = "TIMESTAMP(6)")
    private Instant timestampInstantNow;
    @Column(name = "key_index",columnDefinition = "INT")
    private int key ;

    public void forceUpdate() {
        key++;
    }
}

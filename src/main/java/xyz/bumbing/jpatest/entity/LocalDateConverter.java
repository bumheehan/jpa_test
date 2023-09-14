package xyz.bumbing.jpatest.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String convertToDatabaseColumn(LocalDate plainText) {
        if (plainText != null) {
            return plainText.format(dateTimeFormatter);
        }
        return null;
    }

    @Override
    public LocalDate convertToEntityAttribute(String date) {
        if (date != null) {
            return LocalDate.parse(date, dateTimeFormatter);
        }
        return null;
    }
}

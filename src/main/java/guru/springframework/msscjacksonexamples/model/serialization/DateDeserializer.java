package guru.springframework.msscjacksonexamples.model.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateDeserializer extends JsonDeserializer<OffsetDateTime>  {

    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            // date/time
            .appendPattern("yyyy-MM-dd HH:mm:ss")
            // optional fraction of seconds (from 0 to 9 digits)
            .optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).appendZoneOrOffsetId().optionalEnd()
            // create formatter
            .toFormatter();

    @Override
    public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return OffsetDateTime.parse(p.getText(), this.formatter);
    }
}

package com.luizconrado.weisshaus.solarisbankapi_v2.utilities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MyCustomJsonDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        String zonedDateTimeString = jsonParser.getText();
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(zonedDateTimeString, formatter);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        return localDateTime;
    }
}

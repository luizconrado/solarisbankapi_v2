package com.luizconrado.weisshaus.solarisbankapi_v2.utilities;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonObjectMapper {

    public ObjectMapper getObjectMapper() {

        ObjectMapper mapper = new ObjectMapper();

        // https://stackoverflow.com/questions/45110371/no-string-argument-constructor-factory-method-to-deserialize-from-string-value/45110497
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        return mapper;
    }

}

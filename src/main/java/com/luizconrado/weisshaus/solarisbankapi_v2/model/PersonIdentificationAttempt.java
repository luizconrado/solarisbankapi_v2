package com.luizconrado.weisshaus.solarisbankapi_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentificationAttemptPayload.Payload;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person_identification_attempt", indexes = {
        @Index(columnList = "personId", name = "person_identification_attempt_person_id_hidx"),
        @Index(columnList = "personIdentificationId", name = "person_identification_attempt_person_identification_id_hidx"),
        @Index(columnList = "identificationTime", name = "person_identification_attempt_identification_time_hidx")
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonIdentificationAttempt {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonIgnore
    private String personIdentificationId;

    @JsonIgnore
    private String personId;

    @JsonProperty("result")
    private String result;

    @JsonProperty("reason")
    private String reason;

    @Embedded
    @JsonProperty("payload")
    private Payload payload;

}
package com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentificationAttemptPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class ContactData {

    @JsonProperty("mobilephone")
    private String mobilephone;

    @JsonProperty("email")
    private String email;
}
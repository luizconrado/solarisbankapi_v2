package com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentificationAttemptPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Attachments {

    @JsonProperty("pdf")
    private String pdf;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("audiolog")
    private String audioLog;

    @JsonProperty("xml")
    private String xml;

    @JsonProperty("videolog")
    private String videoLog;

    @JsonProperty("idbackside")
    private String idBackSide;

    @JsonProperty("idfrontside")
    private String idFrontSide;

    @JsonProperty("security1")
    private String security1;

    @JsonProperty("userface")
    private String userface;

    @JsonProperty("security2")
    private String security2;

    @JsonProperty("security_covered")
    private String securityCovered;

    @JsonProperty("security3")
    private String security3;

    public Attachments() {
    }
}

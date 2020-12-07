package com.luizconrado.weisshaus.solarisbankapi_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_identification", indexes = {
        @Index(columnList = "personId", name = "person_identification_person_id_hidx"),
        @Index(columnList = "status", name = "person_identification_status_hidx"),
        @Index(columnList = "completedAt", name = "person_identification_completed_at_hidx")
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonIdentification {

	@Id
    @JsonProperty("id")
    private String id;

    @JsonIgnore
    private String personId;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("url")
    private String url;

    @JsonProperty("status")
    private String status;

    @JsonProperty("completed_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime completedAt;

	@JsonProperty("failure_reason")
	private String failureReason;

    @JsonProperty("proof_of_address_type")
    private String proofOfAddressType;

    @JsonProperty("proof_of_address_issued_at")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	// @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime proofOfAddressIssuedAt;

    @JsonProperty("method")
    private String method;

    @JsonProperty("authorization_expires_at")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	// @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime authorizationExpiresAt;

    @JsonProperty("language")
    private String language;

    @JsonProperty("confirmation_expires_at")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	// @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime confirmationExpiresAt;


    @JsonProperty("iban")
    private String iban;

    @JsonProperty("terms_and_conditions_signed_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime termsAndConditionsSignedAt;


}
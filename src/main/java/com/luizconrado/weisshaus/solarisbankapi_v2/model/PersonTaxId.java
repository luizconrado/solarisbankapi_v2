package com.luizconrado.weisshaus.solarisbankapi_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "person_tax_id", indexes = {
        @Index(columnList = "personId", name = "person_tax_id_person_id_hidx")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonTaxId {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonIgnore
    private String personId;

    @JsonProperty("country")
    private String country;

    @JsonProperty("number")
    private String number;

    @JsonProperty("primary")
    private boolean primaryTaxId;

    @JsonProperty("valid_until")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    // @JsonFormat(pattern = "YYYY-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate validUntil;

    @JsonProperty("reason_no_tin")
    private String reasonNoTin;

    @JsonProperty("reason_description")
    private String reasonDescription;


}
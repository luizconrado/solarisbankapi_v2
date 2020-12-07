package com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentificationAttemptPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.luizconrado.weisshaus.solarisbankapi_v2.utilities.MyCustomJsonDateTimeDeserializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class IdentificationProcess {

    @JsonProperty("result")
    @Column(name = "identification_process_result")
    private String result;

    @JsonProperty("companyid")
    private String companyId;

    @JsonProperty("filename")
    private String fileName;

    @JsonProperty("agentname")
    private String agentName;

    @JsonProperty("identificationtime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//            @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//            @JsonFormat(pattern = Constants.DATETIME_FORMAT)
//            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//            @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//            @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = MyCustomJsonDateTimeDeserializer.class)
    private LocalDateTime identificationTime;

    @JsonProperty("id")
    @Column(name = "identification_process_id")
    private String id;

    @JsonProperty("href")
    private String href;

    @JsonProperty("type")
    private String type;

    @JsonProperty("transactionnumber")
    private String transactionNumber;

    @JsonProperty("reason")
    @Column(name = "identification_process_reason")
    private String reason;

    @JsonProperty("processtype")
    @Column(name = "identification_process_type")
    private String processtype;

    public IdentificationProcess() {
    }
}

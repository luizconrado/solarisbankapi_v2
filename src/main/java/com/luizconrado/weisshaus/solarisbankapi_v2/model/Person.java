package com.luizconrado.weisshaus.solarisbankapi_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("birth_city")
    private String birthCity;

    @JsonProperty("vat_number")
    private String vatNumber;

    @JsonProperty("birth_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    // @JsonFormat(pattern = "YYYY-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;

    @JsonProperty("industry")
    private String industry;

    @JsonProperty("title")
    private String title;

    @JsonProperty("business_city")
    private String businessCity;

    @JsonProperty("birth_country")
    private String birthCountry;

    @JsonProperty("industry_key")
    private String industryKey;

    @JsonProperty("terms_conditions_signed_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime termsConditionsSignedAt;

    @JsonProperty("nace_code")
    private String naceCode;

    @JsonProperty("flagged_by_compliance")
    private boolean flaggedByCompliance;

    @JsonProperty("employment_status")
    private String employmentStatus;

    @JsonProperty("first_name")
    private String firstName;

//    @JsonProperty("address")
//    @OneToOne
//    private PersonAddress address;


    @JsonIgnore
    private String addressLine1;

    @JsonIgnore
    private String addressLine2;

    @JsonIgnore
    private String addressCity;

    @JsonIgnore
    private String addressPostalCode;

    @JsonIgnore
    private String addressState;

    @JsonIgnore
    private String addressCountry;

//    @JsonProperty("contact_address")
//    @OneToOne
//    private PersonContactAddress contactAddress;

    @JsonIgnore
    private String contactAddressLine1;

    @JsonIgnore
    private String contactAddressLine2;

    @JsonIgnore
    private String contactAddressCity;

    @JsonIgnore
    private String contactAddressPostalCode;

    @JsonIgnore
    private String contactAddressState;

    @JsonIgnore
    private String contactAddressCountry;

//    @OneToOne
//    @JsonProperty("tax_information")
//    private PersonTaxInformation taxInformation;

    @JsonIgnore
    private String taxIdSolarisBankId;

    @JsonIgnore
    private String taxIdCountry;

    @JsonIgnore
    private String taxIdNumber;

    @JsonIgnore
    private String taxIdReasonNoTin;

    @JsonIgnore
    private String taxIdReasonDescription;

    @JsonIgnore
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate taxIdValidUntil;

    @JsonIgnore
    private boolean taxIdPrimary;

    @JsonIgnore
    private String TaxInformationMaritalStatus;

    @JsonIgnore
    private String TaxInformationTaxAssessment;


    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("email")
    private String email;

    @JsonProperty("expected_monthly_revenue_cents")
    private long expectedMonthlyRevenueCents;

    @JsonProperty("website_social_media")
    private String websiteSocialMedia;

    @JsonProperty("fatca_crs_confirmed_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime fatcaCrsConfirmedAt;

    @JsonProperty("screening_progress")
    private String screeningProgress;

    @JsonProperty("birth_name")
    private String birthName;

    @JsonProperty("business_trading_name")
    private String businessTradingName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("business_purpose")
    private String businessPurpose;

    @JsonProperty("business_postal_code")
    private String businessPostalCode;

    @JsonProperty("business_address_line_2")
    private String businessAddressLine2;

    @JsonProperty("business_address_line_1")
    private String businessAddressLine1;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("own_economic_interest_signed_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime ownEconomicInterestSignedAt;

    @JsonProperty("business_country")
    private String businessCountry;

    @JsonProperty("salutation")
    private String salutation;

    @JsonIgnore
    private String mobileNumberId;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    @JsonIgnore
    private boolean mobileNumberVerified;

    @JsonProperty("fatca_relevant")
    private boolean fatcaRelevant;

    // https://www.baeldung.com/jackson-nested-values
    @SuppressWarnings("unchecked")
    @JsonProperty("address")
    private void unpackNested(Map<String,Object> address) {
        this.addressLine1 = (String)address.get("line_1");
        this.addressLine2 = (String)address.get("line_2");
        this.addressCity = (String)address.get("city");
        this.addressPostalCode = (String)address.get("postal_code");
        this.addressState = (String)address.get("state");
        this.addressCountry = (String)address.get("country");
//        Map<String,String> owner = (Map<String,String>)brand.get("owner");
//        this.ownerName = owner.get("name");
    }

    // https://www.baeldung.com/jackson-nested-values
    @SuppressWarnings("unchecked")
    @JsonProperty("contact_address")
    private void unpackNested2(Map<String,Object> address) {
        this.contactAddressLine1 = (String)address.get("line_1");
        this.contactAddressLine2 = (String)address.get("line_2");
        this.contactAddressCity = (String)address.get("city");
        this.contactAddressPostalCode = (String)address.get("postal_code");
        this.contactAddressState = (String)address.get("state");
        this.contactAddressCountry = (String)address.get("country");
//        Map<String,String> owner = (Map<String,String>)brand.get("owner");
//        this.ownerName = owner.get("name");
    }

    // https://www.baeldung.com/jackson-nested-values
    @SuppressWarnings("unchecked")
    @JsonProperty("tax_information")
    private void unpackNested3(Map<String,Object> taxInformation) {
        this.TaxInformationTaxAssessment = (String)taxInformation.get("tax_assessment");
        this.TaxInformationMaritalStatus = (String)taxInformation.get("marital_status");

//        Map<String,String> owner = (Map<String,String>)brand.get("owner");
//        this.ownerName = owner.get("name");
    }

}

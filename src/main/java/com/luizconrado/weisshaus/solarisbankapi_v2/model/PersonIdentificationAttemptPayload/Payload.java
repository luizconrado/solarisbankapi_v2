package com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentificationAttemptPayload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {


    @Embedded
    @JsonProperty("identificationprocess")
    private IdentificationProcess identificationProcess;

    @Embedded
    @JsonProperty("contactdata")
    private ContactData contactData;


    @Embedded
    @JsonProperty("attachments")
    private Attachments attachments;


//        @Embedded
//        @JsonProperty("userdata")
//        private UserData userData;


//        @Embedded
//        @JsonProperty("identificationdocument")
//        private IdentificationDocument identificationDocument;
//
//        @Embedded
//        @JsonProperty("customdata")
//        private CustomData customData;
//



//        @Embeddable
//        @Data
//        class UserData {
//
//            @Embedded
//            @JsonProperty("birthday")
//            private Birthday birthday;
//
//            @Embedded
//            @JsonProperty("title")
//            private Title title;
//
//            @Embedded
//            @JsonProperty("firstname")
//            private FirstName firstName;
//
//            @Embedded
//            @JsonProperty("address")
//            private Address address;
//
//            @Embedded
//            @JsonProperty("birthplace")
//            private Birthplace birthplace;
//
//            @Embedded
//            @JsonProperty("birthname")
//            private BirthName birthName;
//
//            @Embedded
//            @JsonProperty("nationality")
//            private Nationality nationality;
//
//            @Embedded
//            @JsonProperty("lastname")
//            private LastName lastName;
//
//            @Embeddable
//            @Data
//            class Birthday {
//
//                @Column(name = "user_data_birthday_original_value")
//                @JsonProperty("original")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                // @JsonFormat(pattern = "YYYY-MM-dd")
//                @JsonDeserialize(using = LocalDateDeserializer.class)
//                @JsonSerialize(using = LocalDateSerializer.class)
//                private LocalDate original;
//
//                @Column(name = "user_data_birthday_correct_value")
//                @JsonProperty("value")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                // @JsonFormat(pattern = "YYYY-MM-dd")
//                @JsonDeserialize(using = LocalDateDeserializer.class)
//                @JsonSerialize(using = LocalDateSerializer.class)
//                private LocalDate value;
//
//                @Column(name = "user_data_birthday_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//
//            @Embeddable
//            @Data
//            class BirthName {
//
//                @Column(name = "user_data_birth_name_original_value")
//                @JsonProperty("original")
//                private String original;
//
//                @Column(name = "user_data_birth_name_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "user_data_birth_name_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//
//            @Embeddable
//            @Data
//            class Title {
//
//                @Column(name = "user_data_title_original_value")
//                @JsonProperty("original")
//                private String original;
//
//                @Column(name = "user_data_title_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "user_data_title_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class FirstName {
//
//                @Column(name = "user_data_first_name_original_value")
//                @JsonProperty("original")
//                private String original;
//
//                @Column(name = "user_data_first_name_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "user_data_first_name_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class Address {
//
//                @Embedded
//                @JsonProperty("zipcode")
//                private ZipCode zipCode;
//
//                @Embedded
//                @JsonProperty("country")
//                private Country country;
//
//                @Embedded
//                @JsonProperty("city")
//                private City city;
//
//                @Embedded
//                @JsonProperty("street")
//                private Street street;
//
//                @Embeddable
//                @Data
//                class ZipCode {
//
//                    @Column(name = "user_data_address_zipcode_original_value")
//                    @JsonProperty("original")
//                    private String original;
//
//                    @Column(name = "user_data_address_zipcode_correct_value")
//                    @JsonProperty("value")
//                    private String value;
//
//                    @Column(name = "user_data_address_zipcode_status")
//                    @JsonProperty("status")
//                    private String status;
//                }
//
//                @Embeddable
//                @Data
//                class Country {
//
//                    @Column(name = "user_data_address_country_original_value")
//                    @JsonProperty("original")
//                    private String original;
//
//
//                    @Column(name = "user_data_address_country_correct_value")
//                    @JsonProperty("value")
//                    private String value;
//
//                    @Column(name = "user_data_address_country_status")
//                    @JsonProperty("status")
//                    private String status;
//                }
//
//                @Embeddable
//                @Data
//                class City {
//
//                    @Column(name = "user_data_address_city_original_value")
//                    @JsonProperty("original")
//                    private String original;
//
//
//                    @Column(name = "user_data_address_city_correct_value")
//                    @JsonProperty("value")
//                    private String value;
//
//                    @Column(name = "user_data_address_city_status")
//                    @JsonProperty("status")
//                    private String status;
//                }
//
//
//                @Embeddable
//                @Data
//                class Street {
//
//                    @Column(name = "user_data_address_street_original_value")
//                    @JsonProperty("original")
//                    private String original;
//
//
//                    @Column(name = "user_data_address_street_correct_value")
//                    @JsonProperty("value")
//                    private String value;
//
//                    @Column(name = "user_data_address_street_status")
//                    @JsonProperty("status")
//                    private String status;
//                }
//
//            }
//
//            @Embeddable
//            @Data
//            class Birthplace {
//
//                @Column(name = "user_data_bithplace_original_value")
//                @JsonProperty("original")
//                private String original;
//
//
//                @Column(name = "user_data_bithplace_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "user_data_bithplace_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class Nationality {
//
//                @Column(name = "user_data_nationality_original_value")
//                @JsonProperty("original")
//                private String original;
//
//
//                @Column(name = "user_data_nationality_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "user_data_nationality_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class LastName {
//
//                @Column(name = "user_data_last_name_original_value")
//                @JsonProperty("original")
//                private String original;
//
//
//                @Column(name = "user_data_last_name_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "user_data_last_name_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//        }

    //        @Embeddable
//        @Data
//        class IdentificationDocument {
//
//            @Embedded
//            @JsonProperty("country")
//            private Country country;
//
//            @Embedded
//            @JsonProperty("number")
//            private Number number;
//
//            @Embedded
//            @JsonProperty("issuedby")
//            private IssuedBy issuedBy;
//
//            @Embedded
//            @JsonProperty("dateissued")
//            private DateIssued dateIssued;
//
//            @Embedded
//            @JsonProperty("type")
//            private Type type;
//
//            @Embedded
//            @JsonProperty("validuntil")
//            private ValidUntil validuntil;
//
//            @Embeddable
//            @Data
//            class Country {
//
//                @Column(name = "document_country_original_value")
//                @JsonProperty("original")
//                private String original;
//
//                @Column(name = "document_country_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "document_country_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class Number {
//
//                @Column(name = "document_number_original_value")
//                @JsonProperty("original")
//                private String original;
//
//
//                @Column(name = "document_number_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "document_number_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class IssuedBy {
//
//                @Column(name = "document_issued_by_original_value")
//                @JsonProperty("original")
//                private String original;
//
//
//                @Column(name = "document_issued_by_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "document_issued_by_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class DateIssued {
//
//                @Column(name = "document_date_issued_original_value")
//                @JsonProperty("original")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                // @JsonFormat(pattern = "YYYY-MM-dd")
//                @JsonDeserialize(using = LocalDateDeserializer.class)
//                @JsonSerialize(using = LocalDateSerializer.class)
//                private LocalDate original;
//
//                @Column(name = "document_date_issued_correct_value")
//                @JsonProperty("value")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                // @JsonFormat(pattern = "YYYY-MM-dd")
//                @JsonDeserialize(using = LocalDateDeserializer.class)
//                @JsonSerialize(using = LocalDateSerializer.class)
//                private LocalDate value;
//
//                @Column(name = "document_date_issued_status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class Type {
//
//                @Column(name = "document_type_original_value")
//                @JsonProperty("original")
//                private String original;
//
//                @Column(name = "document_type_correct_value")
//                @JsonProperty("value")
//                private String value;
//
//                @Column(name = "document_type__status")
//                @JsonProperty("status")
//                private String status;
//            }
//
//            @Embeddable
//            @Data
//            class ValidUntil {
//
//                @Column(name = "document_valid_until_original_value")
//                @JsonProperty("original")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                // @JsonFormat(pattern = "YYYY-MM-dd")
//                @JsonDeserialize(using = LocalDateDeserializer.class)
//                @JsonSerialize(using = LocalDateSerializer.class)
//                private LocalDate original;
//
//                @Column(name = "document_valid_until_correct_value")
//                @JsonProperty("value")
//                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                // @JsonFormat(pattern = "YYYY-MM-dd")
//                @JsonDeserialize(using = LocalDateDeserializer.class)
//                @JsonSerialize(using = LocalDateSerializer.class)
//                private LocalDate value;
//
//                @Column(name = "document_valid_until_status")
//                @JsonProperty("status")
//                private String status;
//            }
//        }
//
//        @Embeddable
//        @Data
//        class CustomData {
//
//            @JsonProperty("custom3")
//            private String custom3;
//
//            @JsonProperty("custom4")
//            private String custom4;
//
//            @JsonProperty("custom1")
//            private String custom1;
//
//            @JsonProperty("custom2")
//            private String custom2;
//
//            @JsonProperty("custom5")
//            private String custom5;
//        }
//


}

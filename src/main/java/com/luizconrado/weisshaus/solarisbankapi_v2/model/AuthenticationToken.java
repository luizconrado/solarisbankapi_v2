package com.luizconrado.weisshaus.solarisbankapi_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private int expiresIn;

    // **** Manually added fields from credentials.json ***
    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("base_endpoint")
    private String baseEndpoint;

    @JsonProperty("host")
    private String host;

    @JsonProperty("api_version")
    private String apiVersion;

    @JsonProperty("authentication_endpoint")
    private String authenticationEndpoint;

}
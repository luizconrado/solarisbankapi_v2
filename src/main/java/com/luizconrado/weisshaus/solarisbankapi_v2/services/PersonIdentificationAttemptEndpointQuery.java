package com.luizconrado.weisshaus.solarisbankapi_v2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentification;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.PersonIdentificationAttempt;
import com.luizconrado.weisshaus.solarisbankapi_v2.utilities.HttpClientResponse;
import com.luizconrado.weisshaus.solarisbankapi_v2.utilities.JacksonObjectMapper;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class PersonIdentificationAttemptEndpointQuery {


    public List<PersonIdentificationAttempt> getPersonIdentificationAttempts(AuthenticationToken token, int pageSize, int pageNumber, PersonIdentification personIdentification) {


        String entityEndpoint = "persons";
        String entityEndpoint2 = "identifications";
        String entityEndpoint3 = "idnow_attempts";
        String baseEndpoint = token.getBaseEndpoint();
        String apiVersion = token.getApiVersion();
        String host = token.getHost();
        String grantType = token.getGrantType();


        ObjectMapper mapper = new JacksonObjectMapper().getObjectMapper();

        List<PersonIdentificationAttempt> personIdentificationAttempts = new ArrayList<>();


        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseEndpoint)
                .path(apiVersion)
                .path(entityEndpoint)
                .path(personIdentification.getPersonId())
                .path(entityEndpoint2)
                .path(personIdentification.getId())
                .path(entityEndpoint3)
                .queryParam("page[number]", 1)
                .queryParam("page[size]", pageSize);

        // Print URI being called:
        // System.out.println(target.getUri().toString());

        Response response = HttpClientResponse.getResponse(token, host, target, "GET");


        // Read Response Status & other information:
//            System.out.println(response.getStatus());
//            System.out.println(response.getStatusInfo());
//            response.getStringHeaders().entrySet().forEach(System.out::println);
//            System.out.println(response.getAllowedMethods());

        if (response == null) {

            System.out.println("Response is NULL");
            throw new NullPointerException("Response from HTTP Call is NULL");

        } else {

            String responseString = response.readEntity(String.class);

//            System.out.println(responseString);
//            System.out.println(response.getStatus());

            if (response.getStatus() >= 200 && response.getStatus() < 300) {

                JsonNode jsonNode = null;

                try {

                    jsonNode = mapper.readTree(responseString);

                } catch (JsonProcessingException e) {
                    System.out.println("getPersonIdentificationAttempts Failed -> jsonNode = mapper.readTree(responseString)");
                    e.printStackTrace();

                }


                try {

                    List<PersonIdentificationAttempt> personIdentificationAttemptsTemp = mapper.readValue(responseString, new TypeReference<List<PersonIdentificationAttempt>>() {
                    });

                    if (personIdentificationAttemptsTemp.size() > 0) {
                        personIdentificationAttemptsTemp.forEach(p -> p.setPersonId(personIdentification.getPersonId()));
                        personIdentificationAttemptsTemp.forEach(p -> p.setPersonIdentificationId(personIdentification.getId()));
                        personIdentificationAttempts.addAll(personIdentificationAttemptsTemp);
                    }

                    return personIdentificationAttempts;


                } catch (JsonProcessingException e) {
                    System.out.println("getPersonTaxIDs Failed -> personTaxIdentificationsTemp = " +
                            "mapper.readValue(responseString, new TypeReference<List<PersonTaxId>>()");
                    e.printStackTrace();

                    return personIdentificationAttempts;

                }


            } else if (response.getStatus() == 404) {

//                System.out.println("404 - Model Not Found");
                return personIdentificationAttempts;

            } else {
                System.out.println(responseString);
                throw new BadRequestException("Callout did not work out");

            }

        }

    }

}

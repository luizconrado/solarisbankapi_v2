package com.luizconrado.weisshaus.solarisbankapi_v2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.Person;
import com.luizconrado.weisshaus.solarisbankapi_v2.utilities.HttpClientResponse;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

public class PersonEndpointQuery {


    public List<Person> getPersons(AuthenticationToken token, int pageSize, int pageNumber) {


        String entityEndpoint = "persons";
        String baseEndpoint = token.getBaseEndpoint();
        String apiVersion = token.getApiVersion();
        String host = token.getHost();
        String grantType = token.getGrantType();


        ObjectMapper mapper = new ObjectMapper();
        // https://stackoverflow.com/questions/45110371/no-string-argument-constructor-factory-method-to-deserialize-from-string-value/45110497
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // create a JSON object
        // ObjectNode payload = mapper.createObjectNode();
        // payload.put("Host", host);
        // payload.put("Authorization", token.getTokenType() + " " + token.getAccessToken());

        // convert `ObjectNode` to pretty-print JSON
        // without pretty-print, use `user.toString()` method
        // String payloadString = null;


        // payloadString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

        // print payloadString
        // System.out.println(payloadString);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseEndpoint)
                .path(apiVersion)
                .path(entityEndpoint)
                .queryParam("page[number]", pageNumber)
                .queryParam("page[size]", pageSize);


        // Print URI being called:
        // System.out.println(target.getUri().toString());


        Response response = HttpClientResponse.getResponse(token, host, target, "get");


        // Read Response Status & other information:
        // System.out.println(response.getStatus());
        // System.out.println(response.getStatusInfo());
        // response.getStringHeaders().entrySet().forEach(System.out::println);
        // System.out.println(response.getAllowedMethods());

        if (response == null) {

            System.out.println("Response is NULL");
            return null;

        } else {

            String responseString = response.readEntity(String.class);

            if (response.getStatus() >= 200 || response.getStatus() < 300) {

                List<Person> personList = null;

                try {
                    personList = mapper.readValue(responseString, new TypeReference<List<Person>>() {
                    });
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

                System.out.println(responseString);
                // System.out.println(personList);

                return personList;

            } else {
                System.out.println(responseString);
                throw new BadRequestException("Callout did not work out");
            }

        }


    }


}

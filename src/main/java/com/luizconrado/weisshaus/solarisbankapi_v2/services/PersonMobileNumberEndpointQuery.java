package com.luizconrado.weisshaus.solarisbankapi_v2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.Person;
import com.luizconrado.weisshaus.solarisbankapi_v2.utilities.HttpClientResponse;
import com.luizconrado.weisshaus.solarisbankapi_v2.utilities.JacksonObjectMapper;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

public class PersonMobileNumberEndpointQuery {


    public void getPersonMobileNumbers(AuthenticationToken token, int pageSize, int pageNumber, Person person) {


        String entityEndpoint = "persons";
        String entityEndpoint2 = "mobile_number";
        String baseEndpoint = token.getBaseEndpoint();
        String apiVersion = token.getApiVersion();
        String host = token.getHost();
        String grantType = token.getGrantType();


        ObjectMapper mapper = new JacksonObjectMapper().getObjectMapper();


        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseEndpoint)
                .path(apiVersion)
                .path(entityEndpoint)
                .path(person.getId())
                .path(entityEndpoint2)
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

                    e.printStackTrace();

                }

                person.setMobileNumberId(jsonNode.get("id").asText());
                person.setMobileNumber(jsonNode.get("number").asText());
                person.setMobileNumberVerified(jsonNode.get("verified").asBoolean());

//                System.out.println(jsonNode.size());
//                System.out.println(jsonNode.isArray());
//                System.out.println(jsonNode.getNodeType().toString());

//                ArrayNode array = (ArrayNode) jsonNode;
//                System.out.println(array.isEmpty());
//                System.out.println(array.fields().hasNext());


                return;

            } else if (response.getStatus() == 404) {

//                System.out.println("404 - Model Not Found");
                return;

            } else {

                System.out.println(responseString);
                throw new BadRequestException("Callout did not work out");

            }

        }

    }

}

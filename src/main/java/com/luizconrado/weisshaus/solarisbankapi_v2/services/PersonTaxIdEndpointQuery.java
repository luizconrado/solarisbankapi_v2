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
import java.time.LocalDate;
import java.util.List;

public class PersonTaxIdEndpointQuery {


    public void getPersonTaxIDs(AuthenticationToken token, int pageSize, int pageNumber, Person person) {


        String entityEndpoint = "persons";
        String entityEndpoint2 = "tax_identifications";
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

                if (jsonNode.isArray() && jsonNode.size() > 1) {

                    throw new BadRequestException("Too many Tax IDs present. You need to make it a One Person to Many Tax IDs relation");

                } else if (jsonNode.isArray() && jsonNode.size() == 1) {

//                person.setMobileNumberId(jsonNode.get("id").asText());
//                person.setMobileNumber(jsonNode.get("number").asText());
//                person.setMobileNumberVerified(jsonNode.get("verified").asBoolean());

                    person.setTaxIdSolarisBankId(jsonNode.get(0).get("id").asText());
                    person.setTaxIdCountry(jsonNode.get(0).get("country").asText());
                    person.setTaxIdNumber(jsonNode.get(0).get("number").asText());
                    person.setTaxIdPrimary(jsonNode.get(0).get("primary").asBoolean());
                    person.setTaxIdReasonNoTin(jsonNode.get(0).get("reason_no_tin").asText());
                    person.setTaxIdReasonDescription(jsonNode.get(0).get("reason_description").asText());
//                https://stackoverflow.com/questions/47695681/json-node-get-aslocaldate
//                https://www.baeldung.com/jackson-serialize-dates
//                    https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
                    person.setTaxIdValidUntil(mapper.convertValue(jsonNode.get(0).get("valid_until"), LocalDate.class));

//                    System.out.println(jsonNode.size());
//                    System.out.println(jsonNode.isArray());
//                System.out.println(jsonNode.getNodeType().toString());

//                ArrayNode array = (ArrayNode) jsonNode;
//                System.out.println(array.isEmpty());
//                System.out.println(array.fields().hasNext());


                    return;

                } else {

                    return;

                }



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

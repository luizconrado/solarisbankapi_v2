package com.luizconrado.weisshaus.solarisbankapi_v2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luizconrado.weisshaus.solarisbankapi_v2.model.AuthenticationToken;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SolarisbankAuthentication {


    public AuthenticationToken getCredentials(String environment) {

        SolarisBankCredentialsLoader credentialsLoader = new SolarisBankCredentialsLoader();
        Map<String, String> credentials = credentialsLoader.getCredentials(environment);

        AuthenticationToken authenticationToken = null;


        ObjectMapper mapper = new ObjectMapper();

        // create a JSON object
        ObjectNode payload = mapper.createObjectNode();
        payload.put("grant_type", credentials.get("grant_type"));
        payload.put("client_id", credentials.get("client_id"));
        payload.put("client_secret", credentials.get("client_secret"));

        // convert `ObjectNode` to pretty-print JSON
        // without pretty-print, use `user.toString()` method
        String payloadString = null;
        try {
            payloadString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

            // print payloadString
            // System.out.println(payloadString);

            String baseEndpoint = credentials.get("base_endpoint");
            String host = credentials.get("host");
            String apiVersion = credentials.get("api_version");
            String authenticationEndpoint = credentials.get("authentication_endpoint");
            String grantType = credentials.get("grant_type");


            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(baseEndpoint)
                    // .path(apiVersion)
                    .path(authenticationEndpoint)
                    .queryParam("grant_type", grantType);

            // Print URI being called:
            // System.out.println(target.getUri().toString());

            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");


            Invocation.Builder request = target
                    .request(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.CONTENT_LENGTH, payloadString.getBytes("UTF-8").length)
                    .header("Host", host);


            Response response = request.post(Entity.entity(payloadString, MediaType.APPLICATION_JSON_TYPE));


            // Read Response Status & other information:
            // System.out.println(response.getStatus());
            // System.out.println(response.getStatusInfo());
            // response.getStringHeaders().entrySet().forEach(System.out::println);
            // System.out.println(response.getAllowedMethods());

            if (response.getStatus() >= 200 || response.getStatus() < 300) {

                authenticationToken = response.readEntity(AuthenticationToken.class);

                authenticationToken.setGrantType(credentials.get("grant_type"));
                authenticationToken.setBaseEndpoint(credentials.get("base_endpoint"));
                authenticationToken.setHost(credentials.get("host"));
                authenticationToken.setApiVersion(credentials.get("api_version"));
                authenticationToken.setAuthenticationEndpoint(credentials.get("authentication_endpoint"));

            } else {
                throw new BadRequestException("Callout did not work out");
            }


        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return authenticationToken;

    }


}

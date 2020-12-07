package com.luizconrado.weisshaus.solarisbankapi_v2.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Auth0CredentialsLoader {

    public Map<String, String> getCredentials(String orgName) {
        Path credentialsPath = Paths.get("credentials.json");
//        System.out.println(credentialsPath.toAbsolutePath().toString());
//        System.out.println();

        JsonNode credentialsJson = null;

        try (InputStream reader = Files.newInputStream(credentialsPath)) {

            ObjectMapper mapper = new ObjectMapper();
            credentialsJson = mapper.readTree(reader).get(orgName);


        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<String, String> credentialsMap = new HashMap<>();


        assert credentialsJson != null;
        credentialsMap.put("client_id", credentialsJson.get("client_id").textValue());
        credentialsMap.put("client_secret", credentialsJson.get("client_secret").textValue());
        credentialsMap.put("grant_type", credentialsJson.get("grant_type").textValue());
        credentialsMap.put("base_endpoint", credentialsJson.get("base_endpoint").textValue());
        credentialsMap.put("host", credentialsJson.get("host").textValue());
        credentialsMap.put("audience", credentialsJson.get("audience").textValue());
        credentialsMap.put("api_version", credentialsJson.get("api_version").textValue());
        credentialsMap.put("authentication_endpoint", credentialsJson.get("authentication_endpoint").textValue());

        return credentialsMap;
    }

}
